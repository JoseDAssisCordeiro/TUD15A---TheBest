package Game;

public class Squarex4Adapter implements SquareInterface{

	private Squarex4 squarex4;
	
	public void updatePoints(Square square, int points){
		
		squarex4.set_points(square, points);
	}
	
}
