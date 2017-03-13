package Game;

import Game.Platform;

public class GameEngine {

	private int _totalPoints;
	private int _record;

	public int get_totalPoints() {
		return _totalPoints;
	}

	public void set_totalPoints(int _totalPoints) {
		this._totalPoints = _totalPoints;
	}

	public int get_record() {
		return _record;
	}

	public void set_record(int _record) {
		this._record = _record;
	}
	
	public void updateRecord(){}
	
	public void addPoints(){}
	
	public void restart(){}
	
	public void undo(){}

}
