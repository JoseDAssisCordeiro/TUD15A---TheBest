package Game;
import Game.Platform;

public class InitialState implements State{
	
	public InitialState() {
		
		
	}
	
	public State PressUp(GameEngine engine){
		return this;
	}

	public State PressDown(GameEngine engine){
		return this;
	}

	public State PressLeft(GameEngine engine){
		return this;
	}

	public State PressRight(GameEngine engine){
		return this;
	}

	public State PressP(GameEngine engine){
		return this;
	}

	public State PressR(GameEngine engine){
		return this;
	}

	public State PressEnter(GameEngine engine){
		
		return new PlayingState();
	}
	

}
