package Game;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class RobotSquare {


	public RobotSquare(){
	}

	
	
	public void draw_robot(Graphics g, int _points, int x, int y, Color color) 
			throws SlickException{
		String filename;
		if(_points < 2048){
	 filename = "robots/" + _points + ".png";
		}
		else{
			filename = "robots/2048.png";
		}
	    Image img = new Image(filename);
	
		img.draw(x,y, 0.2f, color);

		}
	
}
