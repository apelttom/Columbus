package model.units;

import controller.core.CartesianPosition;
import model.Direction;
import model.Speed;

/**
 * Fixed position in given coordinate system. It's versatile enough to be used
 * with whichever 2D coordination system. 2DPosition is represented by two
 * coordinates X, Y which are relative to the metric system. There are also
 * methods which move the position by
 * 
 * @author tapeltauer
 *
 */
public class UnitPosition extends CartesianPosition {

	public UnitPosition(int x, int y) {
		super(x, y);
	}

	private Direction.Course facing = Direction.Course.NORTH;

	public Direction.Course getFacing() {
		return facing;
	}

	public void setFacing(Direction.Course facing) {
		this.facing = facing;
	}

	public void moveNorth(Speed speed) {
		y = y - speed.getSpeed();
	}

	public void moveEast(Speed speed) {
		x = x + speed.getSpeed();
	}

	public void moveSouth(Speed speed) {
		y = y + speed.getSpeed();
	}

	public void moveWest(Speed speed) {
		x = x - speed.getSpeed();
	}

	public void moveNorthEast(Speed speed) {
		moveNorth(speed);
		moveEast(speed);
	}

	public void moveNorthWest(Speed speed) {
		moveNorth(speed);
		moveWest(speed);
	}

	public void moveSouthEast(Speed speed) {
		moveSouth(speed);
		moveEast(speed);
	}

	public void moveSouthWest(Speed speed) {
		moveSouth(speed);
		moveWest(speed);
	}
}
