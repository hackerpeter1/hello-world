package Part5;

public class SparseGridNode {
	private Object occupant;
	private int col;
	private SparseGridNode next;
	
	public SparseGridNode(Object oc, int colNum, SparseGridNode initNext)
	{
		occupant = oc;
		col = colNum;
		next = initNext;
	}
	
	public Object getOccupant() {
		return occupant;
	}
	
	public int getColumn() {
		return col;
	}
	
	public SparseGridNode getNext() {
		return next;
	}
	
	public void setOccupant(Object oc) {
		occupant = oc;
	}
	
	public void setNext(SparseGridNode newNext)
	{
		next = newNext;
	}
}
