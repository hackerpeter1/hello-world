package Part5;

import java.util.ArrayList;
import java.util.LinkedList;

import info.gridworld.grid.AbstractGrid;
import info.gridworld.grid.Location;

public class SparseBoundedGrid<E> extends AbstractGrid{
	private ArrayList<LinkedList<OccupantInCol>> occupantArray; // the array storing the grid elements
	private int numCols;
	private int numRows;
	public SparseBoundedGrid(int rows, int cols) {
		if (rows <= 0)
            throw new IllegalArgumentException("rows <= 0");
		numCols = cols;
		numRows = rows;
		occupantArray = new ArrayList<LinkedList<OccupantInCol>>(); 
		for(int i=0;i<rows;i++) {
			occupantArray.add(new LinkedList<OccupantInCol>());
		}
	}

	public E get(Location loc) {
		if (!isValid(loc))
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
		OccupantInCol ref = occupantArray.get(loc.getRow()).get(loc.getCol());
        return (E) ref.getOccupant();
	}

	public int getNumCols() {
		return numCols;
	}

	public int getNumRows() {
		return numRows;
	}

	@Override
	public ArrayList<Location> getOccupiedLocations() {
		ArrayList<Location> theLocations = new ArrayList<Location>();
		
		for(int i = 0;i<getNumRows();i++) {
			LinkedList<OccupantInCol> row = occupantArray.get(i);
			if(row != null)
			{
				for(OccupantInCol oc:row) {
					Location loc = new Location(i,oc.getColNum());
					theLocations.add(loc);
				}
			}
		}
		return theLocations;
	}


	public boolean isValid(Location loc) {
        return 0 <= loc.getRow() && loc.getRow() < getNumRows()
                && 0 <= loc.getCol() && loc.getCol() < getNumCols();
	}


	public E put(Location loc, Object obj) {
		if (!isValid(loc))
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
        if (obj == null)
            throw new NullPointerException("obj == null");
		
        // Add the object to the grid.
        E oldOccupant = this.get(loc);
        OccupantInCol ref = occupantArray.get(loc.getRow()).get(loc.getCol());
        ref.setOccupant(obj);
        return oldOccupant;
	}

	public E remove(Location loc) {
		if (!isValid(loc))
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
        
        // Remove the object from the grid.
		E r = get(loc);
		occupantArray.get(loc.getRow()).remove(loc.getCol());
        return r;
	}
}
