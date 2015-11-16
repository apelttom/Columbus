package model;

/**
 * Represent the speed of an object in Columbus.
 * @author tapeltauer
 *
 */
public class Speed {

	private final int DEFAULT_SPEED = 2;

	private int speed = DEFAULT_SPEED;

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void resetSpeed() {
		this.speed = DEFAULT_SPEED;
	}

	public boolean isDefaultSpeed() {
		if (this.speed == DEFAULT_SPEED) {
			return true;
		}
		return false;
	}

}
