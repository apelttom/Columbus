package controller.core;

import java.awt.Point;

public class CartesianPosition extends Point {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1406726989987136425L;
	
	protected double x;
	protected double y;
	
	public CartesianPosition(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
}
