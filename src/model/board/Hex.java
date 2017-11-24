package model.board;

import java.awt.Color;
import java.awt.Graphics;

import controller.core.CartesianPosition;

public class Hex{
	
	private HexPosition hexPosition;
//	private HexDimensions hexDimensions;
	// all corners starting from the top one. Point-top oriented 
	private CartesianPosition corners[] = new CartesianPosition[6];
	
	public static final CartesianPosition DEFAULT_HEX_CENTER = new CartesianPosition(0, 0);
		
	public Hex(HexPosition hexPosition, int size){
		this.hexPosition = hexPosition;
		createCorners(size);
	}

	public HexPosition getHexPosition() {
		return hexPosition;
	}

	/**
	 * Corner on index 0 is at the top, next corners continue in counter clock-wise order.
	 * There is only six corners
	 * @param index number from 0 to 5 identifying corner, you want to get coordinates to
	 * @return Cartesian point on the canvas where the current corner should be located
	 */
	public CartesianPosition getCorner(int index){
		return corners[index];
	}
	
	public void paintComponent(Graphics graphics) {
		for (int i = 0; i <= 5; i++) {
			int drawLineFromIndex = i;
			int drawLineToIndex = (i+1) % 6;
			double x1 = this.getCorner(drawLineFromIndex).getX();
			double y1 = this.getCorner(drawLineFromIndex).getY();
			double x2 = this.getCorner(drawLineToIndex).getX();
			double y2 = this.getCorner(drawLineToIndex).getY();
			double distance = Math.hypot(x1-x2, y1-y2);
//			System.out.println("Distance from point ("+x1+", "+y1+") to point"+"("+x2+", "+y2+") is: "+distance);
			graphics.drawLine((int) this.getCorner(drawLineFromIndex).getX(), (int) this.getCorner(drawLineFromIndex).getY(),
					(int) this.getCorner(drawLineToIndex).getX(), (int) this.getCorner(drawLineToIndex).getY());
		}
	}
	
	private void createCorners(int size){
		for (int i = 0; i < corners.length; i++) {
			double angle_deg = 60D * i + 30D;
			double angle_rad = Math.PI / 180D * angle_deg;
			corners[i] = new CartesianPosition(hexPosition.getHexCenter().getX() + size * Math.cos(angle_rad), 
					hexPosition.getHexCenter().getY() + size * Math.sin(angle_rad));
		}
	}
}
