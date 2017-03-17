package Game;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public interface SquareInterface {
	
	public void updatePoints(SquareInterface square, int points);
	public int get_points();
	public void set_points(int points);
	public boolean get_active();
	public void set_active( boolean _active);
	public void draw_square(Graphics g, State state, int tilewidth,
			int tileheight, int x, int y) throws SlickException;
}
