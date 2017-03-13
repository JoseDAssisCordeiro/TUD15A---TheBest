package Game;

import Game.Square;
import java.util.Random;

public class Platform {
	
	private Square[][] _squares;
	
	public Platform(){
		
		int i, j;
		Random random = new Random();
		
		_squares = new Square[4][4];
		
		for(i = 0; i < 4; i ++)
			for(j = 0; j < 4; j++)
				_squares[i][j] = new Square();
		
		for(i = 0; i < 3; i++)
			_squares[random.nextInt(4)][random.nextInt(4)].set_active(true);
		
	}
	
	public boolean compareSquares( Square Q1 , Square Q2) {
		if (Q1.get_points() == Q2.get_points())
			return true;
		else 
			return false;
	}
	
	public void eraseSquare(){
		
		
		
	}
	
	
	//first parameter mantains all the caracteristic
	public void combineSquares(Square Q1, Square Q2) {
		Q1.set_points(Q1.get_points() * 2);
		eraseSquare();
	}
	
	public void moveRight() {
		
		for(int i = 4 ; i > 0 ; i--){
			for(int j = 4; j > 0; j--){
				if (_squares[i][j].get_active() == false){
					
					
				}
			}
		}
		
		for(int i = 4 ; i > 0 ; i--){
			for(int j = 4; j > 0; j--){
				if ( compareSquares(_squares[i][j - 1], _squares[i][j])){
					combineSquares(_squares[i][j - 1], _squares[i][j]);
					
				}
			}
		}
	}
	
	public void moveLeft(){
		
		for(int i = 0 ; i < 4; i++){
			for(int j = 0; j < 4; j++){
				if (_squares[i][j].get_active() == false){

					
				}
			}
		}
		
		for(int i = 0 ; i < 4; i++){
			for(int j = 0; j < 3; j++){
				if ( compareSquares(_squares[i][j], _squares[i][j + 1])){
					combineSquares(_squares[i][j], _squares[i][j + 1]);
					
				}
			}
		}
		
	}
	
	public void moveUp(){
		
		for(int i = 0 ; i < 4; i++){
			for(int j = 0; j < 4; j++){
				if (_squares[j][i].get_active() == false){

					
				}
			}
		}
		
		for(int j = 0 ; j < 4; j++){
			for(int i = 0; i < 3; i++){
				if ( compareSquares(_squares[j][i], _squares[j][i + 1])){
					combineSquares(_squares[j][i], _squares[j][i + 1]);
					
				}
			}
		}
	}
	
	public Square[][] get_squares() {
		return _squares;
	}

	public void set_squares(Square[][] _squares) {
		this._squares = _squares;
	}

	public void moveDown(){
		
		for(int i = 4 ; i > 0 ; i--){
			for(int j = 4; j > 0; j--){
				if (_squares[j][i].get_active() == false){

					
				}
			}
		}
		
		for(int i = 4 ; i > 0 ; i--){
			for(int j = 4; j > 0; j--){
				if ( compareSquares(_squares[j][i - 1], _squares[j][i])){
					combineSquares(_squares[j][i - 1], _squares[j][i]);
					
				}
			}
		}
	}
	
	public boolean checkGameOver(){
		
		boolean someIqual;
		
		for(int i = 0; i < 4; i++)
			for(int j = 0; i > 4; i++){
				if(compareSquares(_squares[j][i], _squares[j][i + 1]))
					return false;

				if(compareSquares(_squares[i][j], _squares[i][j + 1]))
					return false;
				
			}
		
		return true;
	}
	
}
