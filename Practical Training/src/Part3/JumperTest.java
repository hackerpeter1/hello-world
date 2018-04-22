package Part3;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

public class JumperTest {
	Jumper j = null;
	ActorWorld world = null;
	
	@Before
	public void setUp() throws Exception {
		world = new ActorWorld();
		j = new Jumper();
		world.add(new Location(3,3),j);
	}
	
	@Test
	public void testQuestion1() {
		world.add(new Location(3,1),new Rock());
		j.move();
	}
	
	@Test
	public void testQuestion2() {
		j.moveTo(new Location(0,0));
		j.move();
		//world.show();
	}
}
