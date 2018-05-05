package Part2;
import info.gridworld.actor.Bug;

public class ZBug extends Bug
{
	private int steps;
	private int sideLength;
	private int turnTime;
	
	public ZBug(int length)
	{
		steps = 0;
		sideLength = length;
		turnTime = 0;
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
			if(turnTime % 2 == 0) {
				turn();
				turn();
				turn();
				steps = 0;
			}else if(turnTime % 2 == 1) {
				turn();
				turn();
				turn();
				turn();
				turn();
				steps = 0;
			}
			turnTime++;
		}
	}
}