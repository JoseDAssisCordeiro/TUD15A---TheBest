package Game;

import Game.Platform;

public class GameEngine {

	private int _totalPoints;
	private int _record;
	private Platform _platform;
	
	public GameEngine(){
		
		_totalPoints = 0;
		_record = 0;
		_platform = new Platform();
			
	}

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
	
	public void updateRecord(int record){
		
		if(_record < record)
			_record = record;
	}
	
	public void addPoints(int score){
		
		_totalPoints += score;
		
	}
	
	public void restart(){
		
		_totalPoints = 0;
		_platform = new Platform();
		
		
	}
	
	public void undo(){
		
		
		
		
	}

}
