package Game;

import Game.Platform;

public class GameEngine {

	private int _totalPoints;
	private int _record;
	private Platform _platform;
	private Platform _platform_backup;
	private int _totalPoints_backup;
	private boolean _undoDone;
	
	
	
	public GameEngine(){
		
		_totalPoints = 0;
		_record = 0;
		_platform = new Platform();
		_platform_backup = new Platform();
		_undoDone = false;
	}
	
	public Platform getPlatform(){
		return _platform;
	}
	
	public void setBackup(Platform p){
		this._platform_backup.set_squares(p.get_squares());
	}
	
	public void set_undoDone(boolean _undoDone){
		this._undoDone = _undoDone;
	}
	public int get_totalPoints() {
		return _totalPoints;
	}

	public void set_totalPoints(int _totalPoints) {
		this._totalPoints_backup = this.get_totalPoints();
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
		
		if(_undoDone == false){
			this._platform.set_squares(this._platform_backup.get_squares());
			this._totalPoints = this._totalPoints_backup;
			this.set_undoDone(true);
			
		}
		
	}

}
