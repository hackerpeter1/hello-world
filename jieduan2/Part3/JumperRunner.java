package Part3;
import info.gridworld.actor.*;
import info.gridworld.grid.Location;
import java.awt.Color;


public class JumperRunner
{
	public static void main(String[] args)
	{
		ActorWorld world = new ActorWorld();
		
		Jumper j = new Jumper();
		
		j.setColor(Color.orange);
		
		world.add(new Location(0,0), j);
		world.add(new Rock());
		
		world.show();
	}
}