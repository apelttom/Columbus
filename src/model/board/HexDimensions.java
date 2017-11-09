package model.board;

public class HexDimensions {

	private int size;
	private int height;
	private int width;

	public HexDimensions(int size) {
		this.size = size;
		this.height = size * 2;
		this.width = (int) ((Math.sqrt(3) / 2) * this.height);
	}

	public int getSize() {
		return size;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

}
