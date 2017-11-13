package controller.core;

import java.awt.Point;

public class CartesianPosition extends Point {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1406726989987136425L;
	
	protected int x;
	protected int y;
	
	public CartesianPosition(double x, double y){
		this.x = (int) x;
		this.y = (int) y;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
}
