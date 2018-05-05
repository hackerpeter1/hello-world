package info.gridworld.maze;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

/**
 * A <code>MazeBug</code> can find its way in a maze. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class MazeBug extends Bug {
	public Location next;
	public Location last;
	public boolean isEnd = false;
	public Stack<ArrayList<Location>> crossLocation = new Stack<ArrayList<Location>>();
	public Integer stepCount = 0;
	boolean hasShown = false;//final message has been shown
	int left = 1;
	int right = 1;
	int up = 1;
	int down = 1;
	int judge = 0;

	/**
	 * Constructs a box bug that traces a square of a given side length
	 * 
	 * @param length
	 *            the side length
	 */
	public MazeBug() {
		setColor(Color.GREEN);
		last = new Location(0,0);
	}

	/**
	 * Moves to the next location of the square.
	 */
	public void act() {
		if(judge == 0) {
			//-------------------初始点------------------
			ArrayList<Location> temp = new ArrayList<Location>();
			temp.add(this.getLocation());
			temp.add(this.getLocation());
			crossLocation.push(temp);
			judge++;
			//------------------------------------------
		}
		boolean willMove = canMove();
		if (isEnd == true) {
		//to show step count when reach the goal		
			if (hasShown == false) {
				String msg = stepCount.toString() + " steps";
				JOptionPane.showMessageDialog(null, msg);
				hasShown = true;
			}
		} else if (willMove == true) {
			Location currentLoc = getLocation();
			setDirection(getLocation().getDirectionToward(next));
			move();
			last = currentLoc;
			crossLocation.peek().add(next);   //标记走位置
			
			ArrayList<Location> tmp = new ArrayList<Location>();
			tmp.add(getLocation());
			tmp.add(last);
			crossLocation.push(tmp);          //增加新的标志位
			//increase step count when move 
			stepCount++;
		} else if (willMove == false) {
			Location currentLoc = getLocation();
			crossLocation.pop();
			setDirection(currentLoc.getDirectionToward(crossLocation.peek().get(0)));
			moveTo(crossLocation.peek().get(0));
			last = currentLoc;
			next = crossLocation.peek().get(0);
		}
	}

	/**
	 * Find all positions that can be move to.
	 * 
	 * @param loc
	 *            the location to detect.
	 * @return List of positions.
	 */
	public ArrayList<Location> getValid(Location loc) {
		Grid<Actor> gr = getGrid();
		if (gr == null)
			return null;
		ArrayList<Location> valid = new ArrayList<Location>();
		
		return valid;
	}

	/**
	 * Tests whether this bug can move forward into a location that is empty or
	 * contains a flower.
	 * 
	 * @return true if this bug can move.
	 */
	public boolean canMove() {
		Grid<Actor> gr = getGrid();
        if (gr == null)
            return false;
        Location currentLoc = crossLocation.peek().get(0);
        //-----------------------添加筛选可走方向--------------------
        ArrayList<Location> chooseArr = new ArrayList<Location>();
        chooseArr.add(currentLoc.getAdjacentLocation(Location.NORTH));
        chooseArr.add(currentLoc.getAdjacentLocation(Location.SOUTH));
        chooseArr.add(currentLoc.getAdjacentLocation(Location.WEST));
        chooseArr.add(currentLoc.getAdjacentLocation(Location.EAST));
        for(int i=0;i<chooseArr.size();i++) {
        	if(!gr.isValid(chooseArr.get(i))) {
        		chooseArr.remove(i);   //清除可以非法的地方
        		i--;
        	}
        }
        for(int i=0;i<chooseArr.size();i++) {
        	if(crossLocation.peek().get(1).equals(chooseArr.get(i))) {
        		chooseArr.remove(i);   //清楚来的路径
        		i--;
        	}
        }
        for(int j=2;j<crossLocation.peek().size();j++) {
        	if(chooseArr.contains(crossLocation.peek().get(j))) {
        		chooseArr.remove(crossLocation.peek().get(j));   //清除已经标记的位置
        	}
        }
        for(int i=0;i<chooseArr.size();i++) {
        	Actor neighbor = gr.get(chooseArr.get(i));
        	if(neighbor instanceof Rock) {  //清除有石头的地方
        		if(neighbor.getColor().getRed() > 0) {
        			isEnd = true;
        		}
        		chooseArr.remove(i);
        		i--;
        	}
        }
        if(chooseArr.size() == 0) return false;
        //-----------在剩下的位置中随即选择(带拓展)------------------------------
        Random ran = new Random();
        ArrayList<Integer> tempArr = new ArrayList<Integer>();
        for(int i=0;i<chooseArr.size();i++) {
        	switch(currentLoc.getDirectionToward(chooseArr.get(i))) {
		    	case Location.NORTH:
		    		for(int j=0;j<up;j++)
		    			tempArr.add(1);
		    		break;
		    	case Location.EAST:
		    		for(int j=0;j<right;j++) 
		    			tempArr.add(2);
		    		break;
		    	case Location.SOUTH:
		    		for(int j=0;j<down;j++)
		    			tempArr.add(3);
		    		break;
		    	case Location.WEST:
		    		for(int j=0;j<left;j++)
		    			tempArr.add(4);
		    		break;
	        }
        }
        int direction = 0;
        switch(tempArr.get(ran.nextInt(tempArr.size()))) {
        	case 1:
        		direction = Location.NORTH;
        		up++;
        		break;
        	case 2:
        		right++;
        		direction = Location.EAST;
        		break;
        	case 3:
        		down++;
        		direction = Location.SOUTH;
        		break;
        	case 4:
        		left++;
        		direction = Location.WEST;
        		break;
        }
        next = getLocation().getAdjacentLocation(direction);   //下一个要走的节点
        //-----------------------------------------------------------------
        return true;
	}
	/**
	 * Moves the bug forward, putting a flower into the location it previously
	 * occupied.
	 */
	public void move() {
		Grid<Actor> gr = getGrid();
		if (gr == null)
			return;
		Location loc = this.getLocation();
		if (gr.isValid(next)) {
			setDirection(getLocation().getDirectionToward(next));
			moveTo(next);
		} else
			removeSelfFromGrid();
		Flower flower = new Flower(getColor());
		flower.putSelfInGrid(gr, loc);
	}
}
