package Game;

import Game.Square;

public class Platform {
	
	private Square[][] _squares;
	
	public Platform(){
		
		_squares = new Square[4][4];
		
	}
	
	public boolean compareSquares( Square Q1 , Square Q2) {
		if (Q1.get_points() == Q2.get_points())
			return true;
		else 
			return false;
	}
	
	public void eraseSquare(){}
	
	
	//first parameter mantains all the caracteristic
	public void combineSquares(Square Q1, Square Q2) {
		Q1.set_points(Q1.get_points() * 2);
		eraseSquare();
	}
	
	public void moveRight() {
		
		for(int i = 4 ; i > 0 ; i--){
			for(int j = 4; j > 0; j--){
				if (_squares[i][j].get_active() == false){
					for(int k = j ; k > 1; k--){
						_squares[i][k - 1].changeLocation(i , k );
					}
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
					for(int k = j ; k < 3; k++){
						_squares[i][k + 1].changeLocation(i , k );
					}
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
					for(int k = i ; k < 3; k++){
						_squares[j][k + 1].changeLocation(j , k );
					}
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
	
	public void moveDown(){
		
		for(int i = 4 ; i > 0 ; i--){
			for(int j = 4; j > 0; j--){
				if (_squares[j][i].get_active() == false){
					for(int k = i ; k > 1; k--){
						_squares[j][k - 1].changeLocation(j , k );
					}
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
	
	public void checkGameOver(){
		
	}
	
}