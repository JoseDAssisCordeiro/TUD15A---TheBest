package Game;

import org.newdawn.slick.Color;

public interface State {
	
	public State PressUp(GameEngine engine);
	public State PressDown(GameEngine engine);
	public State PressLeft(GameEngine engine);
	public State PressRight(GameEngine engine);
	public State PressP(GameEngine engine);
	public State PressR(GameEngine engine);
	public State PressEnter(GameEngine engine);
	public String getMessage();
	public Color getColor(int points);
	
}
