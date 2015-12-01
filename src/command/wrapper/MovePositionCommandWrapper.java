package command.wrapper;

import model.Speed;
import units.UnitPosition;

public class MovePositionCommandWrapper extends CommandWrapper {
	
	private Speed speed;
	
	public MovePositionCommandWrapper(UnitPosition position, Speed speed) {
		super(position);
		this.speed = speed;
	}
	
	public Speed getSpeed() {
		return speed;
	}
	public void setSpeed(Speed speed) {
		this.speed = speed;
	}
	

}
