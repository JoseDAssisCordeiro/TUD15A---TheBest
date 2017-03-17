package Game;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

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
	
	public void draw_square(Graphics g, State state, int tileWidth,int tileHeight, int x, int y) 
			throws SlickException{
		g.drawRect(x, y, tileWidth, tileHeight);
			
		if(_active){
		
		g.setColor(state.getColor(_points));
		g.fillRect(x + 3, y + 3 ,tileWidth - 5,tileHeight -5);
		g.setColor(Color.white);
		
		g.setColor(Color.darkGray);	        	
    	g.drawString(Integer.toString(_points), x + 35 , y + 35);
		g.setColor(Color.white);
		}
	}
}
