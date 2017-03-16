package Game;

public class Squarex4Adapter implements SquareInterface{

	private Squarex4 squarex4 = new Squarex4();
	
	public void updatePoints(SquareInterface square, int points){
		
		squarex4.set_points(square, points);
	}
	
	private int _points;
	private boolean _active;
	
	public Squarex4Adapter(){
		
		_points = 2;
		_active = false;
	}

	public int get_points() {
		return _points;
	}
	
	public void set_points(int points) {
		this._points = points;
	}
	
	public boolean get_active() {
		return _active;
	}

	public void set_active( boolean _active) {
		this._active = _active;
	}
	
	
	
	
}
