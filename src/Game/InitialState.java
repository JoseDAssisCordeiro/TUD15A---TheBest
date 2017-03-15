package Game;
import Game.Platform;

public class InitialState implements State{
	
	public InitialState() {
		
		
	}
	
	public void PressUp(GameEngine engine){}

	public void PressDown(GameEngine engine){}

	public void PressLeft(GameEngine engine){}

	public void PressRight(GameEngine engine){}

	public void PressP(GameEngine engine){}

	public void PressR(GameEngine engine){}

	public void PressEnter(GameEngine engine){
		
		this = new PlayingState();
	}
	

}
