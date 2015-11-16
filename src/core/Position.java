package core;

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
public class Position {

	private int x = 5;
	private int y = 5;
	private Direction.Course facing = Direction.Course.NORTH;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

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

	public void moveSouthEast(Speed speed) {
		moveSouth(speed);
		moveEast(speed);
	}

	public void moveSouthWest(Speed speed) {
		moveSouth(speed);
		moveWest(speed);
	}

	public void moveNorthWest(Speed speed) {
		moveNorth(speed);
		moveWest(speed);
	}
}
