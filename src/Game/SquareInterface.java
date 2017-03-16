package Game;

public interface SquareInterface {
	
	public void updatePoints(Square square, int points);
	public int get_points();
	public void set_points(int points);
	public boolean get_active();
	public void set_active( boolean _active);
}
