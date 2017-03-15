package Game;

public class PauseState implements State {
	
	public PauseState(){
		
	};
	
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
		
		return new PlayingState();	
				
	};
	
	public State PressR(GameEngine engine){
		
		if(engine.get_totalPoints() > engine.get_record())
			engine.set_record(engine.get_totalPoints());
		engine.set_totalPoints(0);		
		engine.setPlatform(new Platform());			
		return this;
	};
	
	public State PressEnter(GameEngine engine){
		return this;
	};	
	

}
