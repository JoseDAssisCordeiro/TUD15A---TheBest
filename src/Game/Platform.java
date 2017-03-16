package Game;

import Game.Square;
import java.util.Random;

public class Platform {
	
	private SquareInterface[][] _squares;
	private int _activeSquares;
	
	public Platform(){
		
		int i, j, k;
		Random random = new Random();
		
		_squares = new Square[4][4];
		
		for(i = 0; i < 4; i ++)
			for(j = 0; j < 4; j++)
				_squares[i][j] = new Square();

		_activeSquares = 0;
		
		for(i = 0; i < 3; i++){
			j = random.nextInt(4);
			k = random.nextInt(4);
			if(!_squares[j][k].get_active()){
				_squares[j][k].set_active(true);
				_activeSquares++;
			}
		}
		
	}
	
	public boolean compareSquares( SquareInterface Q1 , SquareInterface Q2) {
		if (Q1.get_points() == Q2.get_points() && Q1.get_active() && Q2.get_active())
			return true;
		else 
			return false;
	}
	
	public void eraseSquare(SquareInterface Q){
		Q.set_active(false);
	}
	
	
	//first parameter mantains all the characteristics
	public int combineSquares(SquareInterface Q1, SquareInterface Q2) {
		
		int x = Q2.get_points() * 2;
		
		_activeSquares--;
		Q2.set_points(x);
		eraseSquare(Q1);
		
		return Q2.get_points();
	}
	
	public SquareInterface[][] get_squares() {
				
		return _squares;
	}

	public void set_squares(SquareInterface[][] _squares) {
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 4; j++){
				this._squares[i][j].set_active(_squares[i][j].get_active());
				this._squares[i][j].set_points(_squares[i][j].get_points());
			}
		}
	}

	
	public boolean checkGameOver(){

		if(_activeSquares < 16)
			return false;
		
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 3; j++){
				if(compareSquares(_squares[j][i], _squares[j][i + 1]))
					return false;
				
				if(compareSquares(_squares[j][i], _squares[j+1][i]))
					return false;
			}
		
		for(int i = 0; i < 3; i++){
			if(compareSquares(_squares[3][i], _squares[3][i+1]))
				return false;

			if(compareSquares(_squares[i][3], _squares[i+1][3]))
				return false;
		}
		
		return true;
	}
	
	public boolean checkMoveLeft() {
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 3 ; j++){
				if( compareSquares(_squares[j][i],_squares[j+1][i]))
					return true;
					
				if(_squares[j][i].get_active() == false && _squares[j +1][i].get_active() == true)
					return true;
				
			}
		}
		return false;
	}
	
	public boolean checkMoveRight() {
		for(int i = 3; i > -1; i--){
			for(int j = 3; j > 0  ; j--){
				if( compareSquares(_squares[j][i], _squares[j-1][i]))
					return true;
				if(_squares[j][i].get_active() == false && _squares[j-1][i].get_active() == true)	
					return true;
				
			}
		}
		return false;
	}
	
	public boolean checkMoveDown() {
		for(int i = 3; i > -1; i--){
			for(int j = 3; j > 0  ; j--){
				
				if( compareSquares(_squares[i][j], _squares[i][j-1]))
					return true;
				if(_squares[i][j].get_active() == false && _squares[i][j-1].get_active() == true)	
					return true;
				
								
			}
		}
		return false;
	}

	public boolean checkMoveUp() {
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 3 ; j++){
				if( compareSquares(_squares[i][j],_squares[i][j+1]))
					return true;
					
				if(_squares[i][j].get_active() == false && _squares[i][j+1].get_active() == true)	
					return true;
				
			}
		}
		return false;
	}
	public void randomSquare(){
		
		Random random = new Random();
		
		int i, j;
		if(_activeSquares < 16)
			while(true){
				
				i = random.nextInt(4);
				j = random.nextInt(4);
				if(_squares[i][j].get_active() == false){
					_squares[i][j].set_active(true);
					_squares[i][j].set_points(2);
					_activeSquares++;
					break;
				}
			}
	}
}
