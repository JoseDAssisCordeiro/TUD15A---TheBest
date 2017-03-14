package Game;


import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.command.BasicCommand;
import org.newdawn.slick.command.Command;
import org.newdawn.slick.command.InputProvider;
import org.newdawn.slick.command.InputProviderListener;
import org.newdawn.slick.command.KeyControl;


public class MainFrame extends BasicGame implements InputProviderListener{
	
	public static final int tileWidth = 70;
	public static final int tileHeight = 70;
	
	public static final int startPlatformX = 100;
	public static final int startPlatformY = 100;
	
		
	private String message = "";
	
	private GameEngine engine;
	private Platform platform;
	
	

	public MainFrame() {
		super("The best 2048 game ever");
		engine = new GameEngine();
		platform = new Platform();
	}

	/**
	 * @param args
	 * @throws SlickException 
	 */
	public static void main(String[] args) throws SlickException {
			
	    AppGameContainer app = 
                new AppGameContainer(new MainFrame());
	    app.setDisplayMode(800,600,false);
	    app.start();
	}
	
	

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
				
		g.drawString("The best 2048 game ever, enjoy.", 100, 10);	
		g.drawString("Current score:" + engine.get_totalPoints(), 100, 50);	
		g.drawString("Record: " + engine.get_record(), 300, 50);
		
	   Square[][] tiles = platform.get_squares();
	   for(int i=0; i<tiles.length; i++) {
	        for(int j=0; j<tiles[i].length; j++) {
	        	int x = startPlatformX + tileWidth * i;
	        	int y = startPlatformY + tileHeight * j;
	        	g.drawRect(startPlatformX, startPlatformY, tileWidth, tileHeight);
	        	g.drawRect(x, y, tileWidth, tileHeight);
	        	
	        	if(tiles[i][j].get_active()){
	        	g.setColor(Color.magenta);
	        	g.fillRect(x + 3, y + 3 ,tileWidth - 5,tileHeight -5);
	        	g.setColor(Color.white);
	        	}
	        	
	        	g.setColor(Color.darkGray);	        	
	        	g.drawString(Integer.toString(tiles[i][j].get_points()), x + 35 , y + 35);
	        	g.setColor(Color.white);
	        }
	    }
	
		
		g.drawString(message,0,400);
		g.drawString("Press SPACE to exit",0,500);
		       
      
	}


	@Override
	public void init(GameContainer container) throws SlickException {		
	}

	@Override
	public void update(GameContainer container, int arg1) throws SlickException {
	}
	
	public void keyPressed(int key, char c) {
	}
	
	public void keyReleased(int key, char c) {        
		if(key == Input.KEY_LEFT) {
        	platform.moveLeft();
        }
        else if(key == Input.KEY_RIGHT){
        	platform.moveRight();
        }
        else if(key == Input.KEY_UP){
        	platform.moveUp();
        }
        else if(key == Input.KEY_DOWN){
        	platform.moveDown();
        }
        else if(key == Input.KEY_SPACE){
        	System.exit(0);
        }
	}

	@Override
	public void controlPressed(Command arg0) {
		
	}

	@Override
	public void controlReleased(Command arg0) {		
	}

}
