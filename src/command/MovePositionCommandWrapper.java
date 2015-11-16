package command;

import core.Position;
import model.Speed;

public class MovePositionCommandWrapper extends CommandWrapper {
	
	public MovePositionCommandWrapper(Position position) {
		super(position);
	}
	private Speed speed;
	
	public Speed getSpeed() {
		return speed;
	}
	public void setSpeed(Speed speed) {
		this.speed = speed;
	}
	

}
