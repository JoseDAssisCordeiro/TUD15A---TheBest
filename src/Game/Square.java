package Game;

public class Square {

	private int _points;
	private int _xPos;
	private int _yPos;
	private int _colour;
	private boolean _active;
	
	public Square(){
		
		_points = 2;
		_colour = 0;
		_active = false;
	}
	
	public int get_points() {
		return _points;
	}

	public void set_points(int _points) {
		this._points = _points;
	}

	public int get_colour() {
		return _colour;
	}

	public void set_colour(int _colour) {
		this._colour = _colour;
	}
	
	public boolean get_active() {
		return _active;
	}

	public void set_active( boolean _active) {
		this._active = _active;
	}
	
	
}
