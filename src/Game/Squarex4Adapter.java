package Game;

public class Squarex4Adapter implements SquareInterface{

	private Squarex4 squarex4;
	
	public void updatePoints(Square square, int points){
		
		squarex4.set_points(square, points);
	}
	
	public int get_points() {
		return 0;
	}	
	
	public void set_points(int points) {
	}
	
	public boolean get_active() {
		return true;
	}

	public void set_active( boolean _active) {
	}
	
	
	
}
