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
		if (Q1.get_points() == Q2.get_points() && Q1.get_active() && Q2.get_active())
			return true;
		else 
			return false;
	}
	
	public void eraseSquare(Square Q){
		Q.set_active(false);
	}
	
	
	//first parameter mantains all the characteristics
	public void combineSquares(Square Q1, Square Q2) {
		
		int x = Q2.get_points() * 2;
		
		Q2.set_points(x);
		eraseSquare(Q1);
	}
	
	public void moveDown() {

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
					combineSquares(_squares[j][i - 1], _squares[j][i]);
					for(int k = i-1; k > 0; k--){
						_squares[j][k].set_points(_squares[j][k-1].get_points());
						_squares[j][k].set_active(_squares[j][k-1].get_active());
						_squares[j][k-1].set_active(false);
					}
				}
			}
		}
	}
	
	public void moveLeft(){
		
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
		
//		for(int i = 0 ; i < 4; i++){
//			for(int j = 0; j < 3; j++){
//				if ( compareSquares(_squares[i][j], _squares[i][j + 1])){
//					combineSquares(_squares[i][j], _squares[i][j + 1]);
//					
//				}
//			}
//		}
		
	}
	
	public void moveUp(){
		
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
			for(int i = 0 ; i < 4 ; i++){
				if ( compareSquares(_squares[j][i - 1], _squares[j][i])){
					combineSquares(_squares[j][i], _squares[j][i - 1]);
					for(int k = i + 1; k < 3; k++){
						_squares[j][k].set_points(_squares[j][k+1].get_points());
						_squares[j][k].set_active(_squares[j][k+1].get_active());
						_squares[j][k+1].set_active(false);
					}
				}
			}
		}
	}
	
	public void moveRight(){
		
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
//		
//		for(int i = 3 ; i > 0 ; i--){
//			for(int j = 3; j > 0; j--){
//				if ( compareSquares(_squares[j][i - 1], _squares[j][i])){
//					combineSquares(_squares[j][i - 1], _squares[j][i]);
//					
//				}
//			}
//		}
	}
	
	public Square[][] get_squares() {
				
		return _squares;
	}

	public void set_squares(Square[][] _squares) {
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 4; j++){
				this._squares[i][j].set_active(_squares[i][j].get_active());
				this._squares[i][j].set_colour(_squares[i][j].get_colour());
				this._squares[i][j].set_points(_squares[i][j].get_points());
				this._squares[i][j].set_xPos(_squares[i][j].get_xPos());
				this._squares[i][j].set_yPos(_squares[i][j].get_yPos());
			}
		}
		//this._squares = _squares;
	}


	
	public boolean checkGameOver(){
		
		for(int i = 0; i < 3; i++)
			for(int j = 0; i < 3; i++){
				if(compareSquares(_squares[j][i], _squares[j][i + 1]))
					return false;

				if(compareSquares(_squares[i][j], _squares[i][j + 1]))
					return false;
				
				if(!_squares[i][j].get_active())
					return false;
			}
		
		return true;
	}
	
}
