package Game;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class RobotSquareAdapter implements SquareInterface{



	private int _points;
	private boolean _active;
	private RobotSquare _robot;
	
	public RobotSquareAdapter(){
		_robot = new RobotSquare();
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
	
	public void draw_square(Graphics g, State state, int tileWidth,int tileHeight, int x, int y) 
			throws SlickException{
		g.drawRect(x, y, tileWidth, tileHeight);
		
		if(_active){
		
		g.setColor(state.getColor(_points));
		g.fillRect(x + 3, y + 3 ,tileWidth - 5,tileHeight -5);
		
		_robot.draw_robot(g, _points, x, y, state.getColor(_points).brighter(0.5f));
		g.setColor(Color.white);
		
		
		g.setColor(Color.darkGray);	        	
		g.setColor(Color.white);

		}
	}
}
