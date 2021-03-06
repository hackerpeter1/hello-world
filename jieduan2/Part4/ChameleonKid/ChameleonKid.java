package Part4;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;

public class ChameleonKid extends ModifiedChameleonCritter
{
    public ArrayList<Actor> getActors()
    {
        ArrayList<Actor> actors = new ArrayList<Actor>();
        int[] dirs =
            { Location.AHEAD, Location.HALF_CIRCLE};
        for (Location loc : getLocationsInDirections(dirs))
        {
            Actor a = getGrid().get(loc);
            if (a != null)
                actors.add(a);
        }

        return actors;
    }

    public void processActors(ArrayList<Actor> actors)
    {
        int n = actors.size();
        if (n == 0) {
        	setColor(Color.BLACK);
        	return;
        }
        int r = (int) (Math.random() * n);

        Actor other = actors.get(r);
        setColor(other.getColor());
    }
    
    public ArrayList<Location> getLocationsInDirections(int[] directions)
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        Grid gr = getGrid();
        Location loc = getLocation();
    
        for (int d : directions)
        {
            Location neighborLoc = loc.getAdjacentLocation(getDirection() + d);
            if (gr.isValid(neighborLoc))
                locs.add(neighborLoc);
        }
        return locs;
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