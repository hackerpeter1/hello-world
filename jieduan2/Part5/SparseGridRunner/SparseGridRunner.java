package Part5;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

public class SparseGridRunner {
	 public static void main(String[] args)
	    {
	        ActorWorld world = new ActorWorld();
	        world.addGridClass("Part5.SparseBoundedGrid1");
	        //world.addGridClass("Part5.SparseBoundedGrid");	   
	        world.add(new Location(2, 2), new Bug());
	        world.show();
	    }
}
