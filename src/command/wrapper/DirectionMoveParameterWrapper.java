package command.wrapper;

import model.Direction;
import model.Speed;
import model.units.UnitPosition;

public class DirectionMoveParameterWrapper extends CommandWrapper {

	private Speed speed;
	private Direction.Course course;

	public DirectionMoveParameterWrapper(UnitPosition position, Speed speed, Direction.Course course) {
		super(position);
		this.speed = speed;
		this.course = course;
	}

	public Speed getSpeed() {
		return speed;
	}

	public void setSpeed(Speed speed) {
		this.speed = speed;
	}

	public Direction.Course getCourse() {
		return course;
	}

	public void setCourse(Direction.Course course) {
		this.course = course;
	}

}
