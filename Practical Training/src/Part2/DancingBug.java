package Part2;
import info.gridworld.actor.Bug;

public class DancingBug extends Bug
{
	private int steps;
	private int sideLength;
	private int[] arr;
	private int currentArrIndex;
	
	public DancingBug(int length)
	{
		steps = 0;
		sideLength = length;
		arr = new int[] {1,5,3,7,5,2,4,1,6,2,8,2,3,6,2,5};
		currentArrIndex = 0;
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
			for(int i=0;i<arr[currentArrIndex];i++) {
				turn();
				if(currentArrIndex == 13) {
					currentArrIndex = 0;
				}
			}
			currentArrIndex++;
			steps = 0;
		}
	}
}