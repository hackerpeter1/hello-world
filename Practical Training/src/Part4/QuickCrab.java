package Part4;

import java.util.ArrayList;

import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

public class QuickCrab extends CrabCritter {
    
	public ArrayList<Location> getMoveLocations()
    {
		ArrayList<Location> firstuse = new ArrayList<Location>();
		ArrayList<Location> seconduse = new ArrayList<Location>();
		int[] dirs =
	            { Location.LEFT, Location.RIGHT };
	        for (Location loc : getLocationsInDirections(dirs))
	            if (getGrid().get(loc) == null)
	            	seconduse.add(loc);
	        
		for(int i=0;i<seconduse.size();i++) {
			int direction = this.getLocation().getDirectionToward(seconduse.get(i));
			Location loc = seconduse.get(i).getAdjacentLocation(direction);
			if(this.getGrid().isValid(loc)) {
				if(!(this.getGrid().get(loc) instanceof Rock))
					firstuse.add(loc);
			}
		}
		if(firstuse.size()>0) return firstuse;
		else return seconduse;
    }
}
