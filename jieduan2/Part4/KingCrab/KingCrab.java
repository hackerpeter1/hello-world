package Part4;

import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

public class KingCrab extends CrabCritter{
	public void processActors(ArrayList<Actor> actors) {
        for (Actor a : actors)
        {
            if (!(a instanceof Rock) && !(a instanceof Critter))
                a.removeSelfFromGrid();
        }
        
        ArrayList<Actor> aroundActors = this.getActorsAround();
		for(int i=0;i<aroundActors.size();i++) {
			if(aroundActors.get(i) instanceof CrabCritter) {
				int direction = this.getLocation().getDirectionToward(aroundActors.get(i).getLocation());
				Location loc = aroundActors.get(i).getLocation().getAdjacentLocation(direction);
				if(this.getGrid().isValid(loc)) {
					aroundActors.get(i).moveTo(loc);
				}else aroundActors.get(i).removeSelfFromGrid();
			}
		}
	}
	
    public ArrayList<Actor> getActorsAround()
    {
        return this.getGrid().getNeighbors(this.getLocation());
    }
}
