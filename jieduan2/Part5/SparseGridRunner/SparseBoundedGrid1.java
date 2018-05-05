package Part5;

import java.util.ArrayList;

import info.gridworld.grid.AbstractGrid;
import info.gridworld.grid.Location;

public class SparseBoundedGrid1<E> extends AbstractGrid<E>{
	private SparseGridNode[] occupantArray;
	
	private int numCols;
	private int numRows;
	
	public SparseBoundedGrid1(int rows, int cols)
	{
		if (rows <= 0)
            throw new IllegalArgumentException("rows <= 0");
		if (cols <= 0)
            throw new IllegalArgumentException("rows <= 0");
		numCols = cols;
		numRows = rows;
		occupantArray = new SparseGridNode[rows];
	}
	
	public int getNumRows() {
		return numRows;
	}
	
	public int getNumCols() {
		return numCols;
	}

	public boolean isValid(Location loc) {
        return 0 <= loc.getRow() && loc.getRow() < getNumRows()
                && 0 <= loc.getCol() && loc.getCol() < getNumCols();
	}
	
	public ArrayList<Location> getOccupiedLocations(){
		ArrayList<Location> loc = new ArrayList<Location>();
		
		for(int i=0;i<getNumRows();i++) {
			SparseGridNode p = occupantArray[i];
			while(p!=null) {
				Location tmp = new Location(i,p.getColumn());
				loc.add(tmp);
				p = p.getNext();
			}
		}
		return loc;
	}
	
	public E get(Location loc) {
		if(!isValid(loc))
			throw new IllegalArgumentException("Location " + loc
													+ " is not valid");
		SparseGridNode p = occupantArray[loc.getRow()];
		while(p!=null) {
			if(loc.getCol() == p.getColumn()) {
				return (E) p.getOccupant();
			}
			p = p.getNext();
		}
		return null;
	}
	
	public E put(Location loc, E obj) {
		if(!isValid(loc))
			throw new IllegalArgumentException("Location " + loc
													+ " is not valid");
		if(obj == null) 
			throw new NullPointerException("obj = = null");
		E oldOccupant = remove(loc);
		
		SparseGridNode p = occupantArray[loc.getRow()];
		occupantArray[loc.getRow()] = new SparseGridNode(obj, loc.getCol(), p);
		return oldOccupant;
	}

	public E remove(Location loc) {
		if(!isValid(loc))
			throw new IllegalArgumentException("Location " + loc
													+ " is not valid");
		E obj = get(loc);
		if(obj == null) return null;
		SparseGridNode p = occupantArray[loc.getRow()];
		if(p!=null) {
			if(p.getColumn() == loc.getCol()) {
				occupantArray[loc.getRow()] = p.getNext();
			}
			else {
				SparseGridNode q = p.getNext();
				while(q!=null && q.getColumn() != loc.getCol()) {
					p = p.getNext();
					q = q.getNext();
				}
				
				if(q!=null) p.setNext(q.getNext());;
			}
		}
		return obj;
	}
}
