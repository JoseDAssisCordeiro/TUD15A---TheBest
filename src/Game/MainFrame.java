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
	

	private Command moveLeft = new BasicCommand("moveLeft");
	private Command moveRight = new BasicCommand("moveRight");
	private Command moveUp = new BasicCommand("moveUp");
	private Command moveDown = new BasicCommand("moveDown");	
	
	private InputProvider provider;
	private String message = "";
	

	public MainFrame() {
		super("The best 2048 game ever");
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @throws SlickException 
	 */
	public static void main(String[] args) throws SlickException {
		
		// TODO Auto-generated method stub
		
	    AppGameContainer app = 
                new AppGameContainer(new MainFrame());
	    app.setDisplayMode(800,600,false);
	    app.start();
	}
	
	

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		g.drawString("The best 2048 game ever, enjoy.", 100, 10);
		
		int startPlatformX = 100;
		int startPlatformY = 100;
		for (int i=0; i<4; i++) {
			startPlatformX+= tileWidth;
			for (int j=0; j<4; j++) {
				g.drawRect(startPlatformX, startPlatformY, tileWidth, tileHeight);
//				g.setColor(Color.yellow);
//				g.fillRect(startPlatformX,platformY,40,40);
//				g.setColor(Color.white);
				g.drawString(Integer.toString(4* j + i), startPlatformX, startPlatformY);
				startPlatformY+= tileHeight;
			}
			startPlatformY = 100;
		}
		
		
		g.drawString(message,0,400);
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		// TODO Auto-generated method stub
		provider = new InputProvider(container.getInput());
		provider.addListener(this);
		
		provider.bindCommand(new KeyControl(Input.KEY_LEFT), moveLeft);
		provider.bindCommand(new KeyControl(Input.KEY_UP), moveUp);
		provider.bindCommand(new KeyControl(Input.KEY_RIGHT), moveRight);
		provider.bindCommand(new KeyControl(Input.KEY_DOWN), moveDown);

		
	}

	@Override
	public void update(GameContainer arg0, int arg1) throws SlickException {
		// TODO Auto-generated method stub
		
	}
	
	public void controlReleased(Command command) {
		message = "Released: "+ command;
	}
	
	public void controlPressed(Command command) {
		message = "Pressed: "+ command;
	}
	public void keyPressed(int key, char c) {
		
	}

}
