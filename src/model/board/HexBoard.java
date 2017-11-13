package model.board;

import controller.core.CartesianPosition;

public class HexBoard {

	private Hex hex;
	
	public static final int DEFAULT_SIZE = 30;
	public static final CartesianPosition DEFAULT_HEX_CENTER = new CartesianPosition(0, 0);
	
	public HexBoard(){
//		ArrayList<Hex> board = new ArrayList<Hex>(10);
		//TODO: create a testing algorithm that will create and then draw hexagons
//		for (int i = 0; i < 2; i++) {
//			board.add(new Hex(new HexPosition(x, y, z, hexCenter)))
//		}
		hex = new Hex(new HexPosition(0, 0, 0, new CartesianPosition(150, 150)), new HexDimensions(10));
	}

	public Hex getHex() {
		return hex;
	}
	
}
