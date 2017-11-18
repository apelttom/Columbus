package model.board;

import controller.core.CartesianPosition;

public class HexPosition {
	
	/*
	 * Cube coordinate system as explained in https://www.redblobgames.com/grids/hexagons/
	 */
	private int x;
	private int y;
	private int z;
	private CartesianPosition hexCenter;
	
	
	public HexPosition(int x, int y, int z, CartesianPosition hexCenter) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.hexCenter = hexCenter;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}

	public CartesianPosition getHexCenter() {
		return hexCenter;
	}
	

}
