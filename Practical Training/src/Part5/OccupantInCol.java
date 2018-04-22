package Part5;

public class OccupantInCol
{
    private Object occupant;
    private int col;
    public OccupantInCol(Object oc, int cols) {
    	col = cols;
    	occupant = oc;
    }
    
	public int getColNum() {
		return col;
	}
	
	public Object getOccupant() {
		return occupant;
	}
	
	public void setOccupant(Object oc) {
		occupant = oc;
	}
}