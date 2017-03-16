package Game;

public class Square implements SquareInterface{

	private int _points;
	private boolean _active;
	
	public Square(){
		
		_points = 2;
		_active = false;
	}

	public int get_points() {
		return _points;
	}
	
	public void updatePoints(SquareInterface square, int points){ 
		
		square.set_points(points);
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
