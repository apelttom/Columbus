package model.board;

public class Hex {
	
	private HexPosition hexPosition;
	private HexDimensions hexDimensions;
	
	public Hex(){
		hexPosition = new HexPosition(0, 0, 0, HexBoard.DEFAULT_CENTER_POINT);
		hexDimensions = new HexDimensions(HexBoard.DEFAULT_SIZE);
	}
	
	public Hex(HexPosition hexPosition, HexDimensions hexDimensions){
		this.hexPosition = hexPosition;
		this.hexDimensions = hexDimensions;
	}
	
	public Hex(HexPosition hexPosition){
		this.hexPosition = hexPosition;
		hexDimensions = new HexDimensions(HexBoard.DEFAULT_SIZE);
	}

	public HexPosition getHexPosition() {
		return hexPosition;
	}
	
}
