package Game;

import Game.Platform;

public class GameOverState implements State{
	
	public State PressUp(GameEngine engine){
		return this;
	};
	public State PressDown(GameEngine engine){
		return this;
	};
	public State PressLeft(GameEngine engine){
		return this;
	};
	public State PressRight(GameEngine engine){
		return this;
	};


	public State PressP(GameEngine engine){
		return this;
	};
	
	public State PressR(GameEngine engine){
		return this;
	};
	
	public State PressEnter(GameEngine engine){
		
		if(engine.get_totalPoints() > engine.get_record())
			engine.set_record(engine.get_totalPoints());
		engine.set_totalPoints(0);		
		engine.setPlatform(new Platform());		
		engine.setBackup(engine.getPlatform());
		
		return this;
	};
	
	
}
