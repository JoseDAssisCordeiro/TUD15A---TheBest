package Game;

import org.newdawn.slick.Color;

import Game.Platform;

public class PlayingState implements State{
	
	public PlayingState(){}
	
	public State PressUp(GameEngine engine){

		Platform platform = engine.getPlatform();
		
		if(platform.checkMoveUp()){
			
			int points = engine.get_totalPoints();
			Square[][] _squares = platform.get_squares();
			engine.set_undoDone(false);
			engine.setBackup(platform);
			
			for(int j = 0; j < 4; j++){
				for(int i = 0 ; i < 4 ; i++){
					if (_squares[j][i].get_active() == false){
						for(int k = i + 1; k < 4; k++){
							if (_squares[j][k].get_active() == true){
								_squares[j][i].set_points(_squares[j][k].get_points());
								_squares[j][i].set_active(true);
								_squares[j][k].set_active(false);
								break;
							}
						}
					}
				}
			}
			
			
			for(int j = 0; j < 4; j++){
				for(int i = 0 ; i < 3 ; i++){
					if ( platform.compareSquares(_squares[j][i + 1], _squares[j][i])){
						points += platform.combineSquares(_squares[j][i + 1], _squares[j][i]);
						for(int k = i + 1; k < 3; k++){
							_squares[j][k].set_points(_squares[j][k+1].get_points());
							_squares[j][k].set_active(_squares[j][k+1].get_active());
							_squares[j][k+1].set_active(false);
						}
					}
				}
			}
			
			
			engine.set_totalPoints(points);
			platform.randomSquare();
			
			if(platform.checkGameOver())
				return new GameOverState();
		}
		
		return this;
		
	}
	
	public State PressDown(GameEngine engine){
		
		Platform platform = engine.getPlatform();
		
		if(platform.checkMoveDown()){
			
			int points = engine.get_totalPoints();
			Square[][] _squares = platform.get_squares();
			engine.set_undoDone(false);
			engine.setBackup(platform);
						
			for(int j = 0; j < 4; j++){
				for(int i = 3 ; i > 0 ; i--){
					if (_squares[j][i].get_active() == false){
						for(int k = i - 1; k > -1; k--){
							if (_squares[j][k].get_active() == true){
								_squares[j][i].set_points(_squares[j][k].get_points());
								_squares[j][i].set_active(true);
								_squares[j][k].set_active(false);
								break;
							}
						}
					}
				}
			}

			for(int j = 0; j < 4; j++){
				for(int i = 3 ; i > 0 ; i--){
					if ( platform.compareSquares(_squares[j][i - 1], _squares[j][i])){
						points += platform.combineSquares(_squares[j][i - 1], _squares[j][i]);
						for(int k = i-1; k > 0; k--){
							_squares[j][k].set_points(_squares[j][k-1].get_points());
							_squares[j][k].set_active(_squares[j][k-1].get_active());
							_squares[j][k-1].set_active(false);
						}
					}
				}
			}

			engine.set_totalPoints(points);	
			platform.randomSquare();
			
			if(platform.checkGameOver())
				return new GameOverState();
		}
		
		return this;
	}
	
	public State PressLeft(GameEngine engine){
		
		Platform platform = engine.getPlatform();
		
		if(platform.checkMoveLeft()){
			
			int points = engine.get_totalPoints();
			Square[][] _squares = platform.get_squares();
			engine.set_undoDone(false);
			engine.setBackup(platform);
		
			for(int i = 0; i < 4; i++){
				for(int j = 0 ; j < 4 ; j++){
					if (_squares[j][i].get_active() == false){
						for(int k = j + 1; k < 4; k++){
							if (_squares[k][i].get_active() == true){
								_squares[j][i].set_points(_squares[k][i].get_points());
								_squares[j][i].set_active(true);
								_squares[k][i].set_active(false);
								break;
							}
						}
					}
				}
			}
			
			for(int i = 0 ; i < 4 ; i++){
				for(int j = 0; j < 3; j++){
					if (platform.compareSquares(_squares[j][i], _squares[j+1][i])){
						points += platform.combineSquares(_squares[j+1][i], _squares[j][i]);
						for(int k = j + 1; k < 3; k++){
							_squares[k][i].set_points(_squares[k+1][i].get_points());
							_squares[k][i].set_active(_squares[k+1][i].get_active());
							_squares[k+1][i].set_active(false);
						}
					}
				}
			}
			
			engine.set_totalPoints(points);
			platform.randomSquare();
		}

		if(platform.checkGameOver())
			return new GameOverState();
		
		return this;
	}
	
	public State PressRight(GameEngine engine){
		
		Platform platform = engine.getPlatform();
		
		if(platform.checkMoveRight()){
			
			int points = engine.get_totalPoints();
			Square[][] _squares = platform.get_squares();
			engine.set_undoDone(false);
			engine.setBackup(platform);
		
			for(int i = 0; i < 4; i++){
				for(int j = 3 ; j > 0 ; j--){
					if (_squares[j][i].get_active() == false){
						for(int k = j - 1; k > - 1; k--){
							if (_squares[k][i].get_active() == true){
								_squares[j][i].set_points(_squares[k][i].get_points());
								_squares[j][i].set_active(true);
								_squares[k][i].set_active(false);
								break;
							}
						}
					}
				}
			}

			for(int i = 0 ; i < 4 ; i++){
				for(int j = 3; j > 0; j--){
					if ( platform.compareSquares(_squares[j - 1][i], _squares[j][i])){
						points += platform.combineSquares(_squares[j - 1][i], _squares[j][i]);
						for(int k = j - 1; k > 0; k--){
							_squares[k][i].set_points(_squares[k-1][i].get_points());
							_squares[k][i].set_active(_squares[k-1][i].get_active());
							_squares[k-1][i].set_active(false);
						}
					}
				}
			}
			
			engine.set_totalPoints(points);
			platform.randomSquare();

			if(platform.checkGameOver())
				return new GameOverState();
			
		}
		return this;
	}
	
	public State PressP(GameEngine engine){
		
		return new PauseState();
	}
	
	public State PressR(GameEngine engine){
		
		if(engine.get_totalPoints() > engine.get_record())
			engine.set_record(engine.get_totalPoints());
		engine.set_totalPoints(0);
		engine.setPlatform(new Platform());
		engine.setBackup(engine.getPlatform());
		
		return new PlayingState();
	}
	
	public State PressEnter(GameEngine engine){
		
		return this;
	}
	
	public State PressBack(GameEngine engine){
		engine.undo();
		return this;
	};
	
	public String getMessage() {
		String message =  new StringBuilder()
	      .append("Press p to pause\n")
	      .append("Press r to restart game\n")
	      .append("Press BACKSPACE to undo\n")
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
