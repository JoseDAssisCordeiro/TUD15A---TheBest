package Game;

import org.newdawn.slick.Color;

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
		
		return new PlayingState();
	};
	
	public State PressBack(GameEngine engine){
		return this;
	};
	
	public String getMessage() {
		String message = new StringBuilder()
	      .append("*** GAME OVER ***\n")
	      .append("Press ENTER to restart\n")
	      .append("Press SPACE to exit\n")
	      .toString();

		return message;
	}

	public Color getColor(int points) {
		Color color = new Color(255, 255, 204);
		while(points != 1){
			color = color.darker(0.2f);
			points /= 2; 
		}
		
		return color;
	}
	
	
}
