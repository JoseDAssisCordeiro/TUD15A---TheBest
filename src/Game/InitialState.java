package Game;

import org.newdawn.slick.Color;

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
	
	public State PressBack(GameEngine engine){
		return this;
	};

	public String getMessage() {
		String message = new StringBuilder()
        .append("The goal of the game is to merge numbers together (powers of 2)\n")
        .append("in order to reach the ultimate '2048' tile.\n")
        .append("When you join 2 tiles together, they merge into the new one\n")
        .append("with a number that is the addition of the previous one points.\n")
        .append("After every joining you get the points, you can try to reach new record!\n")
        .append("To move the tiles, simply press up/down/left/right buttons.\n")
        .append("If you want to have the break just press\n")
        .append("\nPress ENTER to start\n")
        .append("Press SPACE to exit")
        .toString();

		return message;
	}

	public Color getColor(int points) {
		return Color.pink;
	}

}
