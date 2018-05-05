package Part4;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Set;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

public class BlusterCritter extends Critter{
	private static int value;
	private Color currentColor;
	private Color brightColor;
	private Color darkColor;
	
	public BlusterCritter(int num){
		value = num;
		currentColor = this.getColor();
		brightColor = this.getColor().brighter();
		brightColor = brightColor.brighter();
		darkColor = this.getColor().darker();
		darkColor = darkColor.darker();
	}
	
    public ArrayList<Actor> getActors()
    {
    	ArrayList<Actor> tmp = new ArrayList<Actor>();
    	int row = getLocation().getRow();
    	int col = getLocation().getCol();
    	for(int i = row - 2;i <= row + 2;i++) {
    		for(int j = col - 2;j <= col + 2;j++) {
    			if(i == row && j == col) continue;
    			if(!this.getGrid().isValid(new Location(i,j))) continue;
    			Actor a = this.getGrid().get(new Location(i,j));
    			if(a != null) {
    				tmp.add(a);
    			}
    		}
    	}
        return tmp;
    }
	
	public void processActors(ArrayList<Actor> actors)
    {
    	int size = actors.size();
    	
    	if(size >= value) {
            this.setColor(brightColor);
    	}else {
            this.setColor(darkColor);
    	}
    }
	
    public void makeMove(Location loc)
    {
        if (loc == null)
            removeSelfFromGrid();
        else {
        	setDirection(getLocation().getDirectionToward(loc));
        	moveTo(loc);
        	ArrayList<Actor> actors = this.getActors();
        	this.processActors(actors);
        }
    }
}
