package Part2;
import info.gridworld.actor.Bug;

public class SpiralBug extends Bug
{
	private int steps;
	private int sideLength;
	private int turnTime;
	
	public SpiralBug(int length)
	{
		steps = 0;
		sideLength = length;
	}


	public void act()
	{
		if(steps < sideLength && canMove())
		{
			move();
			steps++;
		}
		else
		{
			turn();
			turn();
			steps = 0;
			turnTime++;
			if(turnTime % 2 == 0) sideLength+=2;
		}
	}
}