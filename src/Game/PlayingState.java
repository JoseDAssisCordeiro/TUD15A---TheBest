package Game;

public class PlayingState implements State{
	
	public void PressUp(GameEngine engine){
		
		int points = 0;
		Platform platform = engine.getPlatform();
		Square[][] _squares = platform.get_squares();
		
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
				if ( compareSquares(_squares[j][i - 1], _squares[j][i])){
					points += combineSquares(_squares[j][i - 1], _squares[j][i]);
					for(int k = i-1; k > 0; k--){
						_squares[j][k].set_points(_squares[j][k-1].get_points());
						_squares[j][k].set_active(_squares[j][k-1].get_active());
						_squares[j][k-1].set_active(false);
					}
				}
			}
		}
		
		engine.set_totalPoints();
		
		
	}
	
	public void PressDown(GameEngine engine){}
	
	public void PressLeft(GameEngine engine){}
	
	public void PressRight(GameEngine engine){}
	
	public void PressP(GameEngine engine){}
	
	public void PressR(GameEngine engine){}
	
	public void PressEnter(GameEngine engine){}
	
}
