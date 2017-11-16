package model.board;

import controller.core.CartesianPosition;

public class Hex {
	
	private HexPosition hexPosition;
	private HexDimensions hexDimensions;
	// all corners starting from the top one. Point-top oriented 
	private CartesianPosition corners[] = new CartesianPosition[6];
	
	public Hex(){
		hexPosition = new HexPosition(0, 0, 0, HexBoard.DEFAULT_HEX_CENTER);
		hexDimensions = new HexDimensions(HexBoard.DEFAULT_SIZE);
		createCorners();
	}
	
	public Hex(HexPosition hexPosition, HexDimensions hexDimensions){
		this.hexPosition = hexPosition;
		this.hexDimensions = hexDimensions;
		createCorners();
	}
	
	public Hex(HexPosition hexPosition){
		this.hexPosition = hexPosition;
		hexDimensions = new HexDimensions(HexBoard.DEFAULT_SIZE);
		createCorners();
	}

	public HexPosition getHexPosition() {
		return hexPosition;
	}

	public HexDimensions getHexDimensions() {
		return hexDimensions;
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
	
	private void createCorners(){
		for (int i = 0; i < corners.length; i++) {
			double angle_deg = 60 * i + 30;
			double angle_rad = Math.PI / 180 * angle_deg;
			corners[i] = new CartesianPosition(hexPosition.getHexCenter().getX() + hexDimensions.getSize() * Math.cos(angle_rad), 
					hexPosition.getHexCenter().getY() + hexDimensions.getSize() * Math.sin(angle_rad));
		}
	}
}
