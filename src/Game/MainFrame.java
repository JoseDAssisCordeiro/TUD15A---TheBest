package Game;


import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.command.Command;
import org.newdawn.slick.command.InputProviderListener;




public class MainFrame extends BasicGame implements InputProviderListener{
	
	public static final int tileWidth = 70;
	public static final int tileHeight = 70;
	
	public static final int startPlatformX = 100;
	public static final int startPlatformY = 100;
	
	
	private State state;
	private GameEngine engine;
	private Platform platform;
	

	public MainFrame() {
		super("The best 2048 game ever");
		state = new InitialState();
		engine = GameEngine.getInstance();
		platform = engine.getPlatform();
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
		
		String message = state.getMessage();

		g.drawString(message,10,400);
		
		
		printTiles(g, tiles);
		         
	}


	private void printTiles(Graphics g, Square[][] tiles) {
		
		for(int i=0; i<tiles.length; i++) {
	        for(int j=0; j<tiles[i].length; j++) {
	        	int x = startPlatformX + tileWidth * i;
	        	int y = startPlatformY + tileHeight * j;
	        	g.drawRect(startPlatformX, startPlatformY, tileWidth, tileHeight);
	        	g.drawRect(x, y, tileWidth, tileHeight);
	        	
	        	if(tiles[i][j].get_active()){
	        	
	        	g.setColor(state.getColor(tiles[i][j].get_points()));
	        	g.fillRect(x + 3, y + 3 ,tileWidth - 5,tileHeight -5);
	        	g.setColor(Color.white);
	        	
	        	
	        	g.setColor(Color.darkGray);	        	
	        	g.drawString(Integer.toString(tiles[i][j].get_points()), x + 35 , y + 35);
	        	g.setColor(Color.white);
	        	}
	        }
	    }
	}

	@Override
	public void init(GameContainer container) throws SlickException {		
	}

	@Override
	public void update(GameContainer container, int arg1) throws SlickException {
		platform = engine.getPlatform();
	}
	
	public void keyPressed(int key, char c) {
	}
	
	public void keyReleased(int key, char c) { 
		switch (key) {
        case Input.KEY_UP:  
        	state = state.PressUp(engine);
            break;
        case Input.KEY_DOWN:  
        	state = state.PressDown(engine);
            break;
        case Input.KEY_LEFT:  
        	state = state.PressLeft(engine);
            break;
        case Input.KEY_RIGHT:  
        	state = state.PressRight(engine);
            break;
        case 25:  
        	state = state.PressP(engine);
            break;
        case 19:  
        	state = state.PressR(engine);
            break;
        case Input.KEY_ENTER:  
        	state = state.PressEnter(engine);
            break;
        case Input.KEY_BACK:  
        	state = state.PressBack(engine);
            break;
        case Input.KEY_SPACE:  
        	System.exit(0);
            break;
		}
	}

	@Override
	public void controlPressed(Command arg0) {
		
	}

	@Override
	public void controlReleased(Command arg0) {		
	}
}
