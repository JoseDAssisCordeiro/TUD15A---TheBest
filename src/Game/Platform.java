package Game;

import Game.Square;

public class Platform {
	
	private Square[][] _squares;
	
	public Platform(){
		
		_squares = new Square[4][4];
		
	}
	
	public Square[][] get_squares() {
		return _squares;
	}

	public void set_squares(Square[][] _squares) {
		this._squares = _squares;
	}

	public void compareSquares(){}
	
	public void moveRight(){}
	
	public void moveLeft(){}
	
	public void moveUp(){}
	
	public void moveDown(){}
	
	public void checkGameOver(){}
	
}