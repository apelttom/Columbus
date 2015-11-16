package model;

import java.util.Random;

/**
 * This class represents the direction in Columbus. Whenever you want to enhance
 * an object with a direction, use this class and its methods.
 * 
 * @author tapeltauer
 *
 */
public class Direction {

	/**
	 * Enumeration representing the basic 8 directions. It corresponds with the
	 * HEX map system this game is using.
	 * 
	 * @author tapeltauer
	 *
	 */
	public enum Course {
		NORTH, NORTHEAST, EAST, SOUTHEAST, SOUTH, SOUTHWEST, WEST, NORTHWEST;

		private static Random rnd = new Random();

		/**
		 * Used in case you need random direction.
		 * @return - random direction
		 */
		public Course randomCourse() {
			return Course.values()[rnd.nextInt(8)];
		}
	}
}
