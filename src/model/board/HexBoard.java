package model.board;

import java.awt.Graphics2D;

import controller.core.CartesianPosition;

public class HexBoard {

	private Hex centralHex;
	private int userDefinedHexSize = -1;
	private HexDimensions boardSettingsHexDimension;
	private double maxHexesNumberWidth;
	private double maxHexesNumberHeight;

	public static final int DEFAULT_SIZE = 30;

	public HexBoard(int maxWidth, int maxHeight) {
		// ArrayList<Hex> board = new ArrayList<Hex>(10);
		// TODO: create a testing algorithm that will create and then draw
		// hexagons
		// for (int i = 0; i < 2; i++) {
		// board.add(new Hex(new HexPosition(x, y, z, hexCenter)))
		// }

		// This part serves as the movement range calculator. Originaly I wanted
		// to use it as a board creator, but then I understood better
		// ArrayList<Hex> board = new ArrayList<>();
		// int n = 2;
		// for (int dx = -n; dx < n; dx++) {
		// for (int dy = Math.max(-n, -dx-n); dy < Math.min(n, -dx+n); dy++) {
		// int dz = -dx-dy;
		// board.add(new Hex(new HexPosition(dx, dy, dz,
		// createNewHexCenterPoint(dx,dy,dz))));
		// }
		// }
		if (this.userDefinedHexSize == -1) {
			this.boardSettingsHexDimension = new HexDimensions(DEFAULT_SIZE);
		} else {
			this.boardSettingsHexDimension = new HexDimensions(this.userDefinedHexSize);
		}
		this.maxHexesNumberWidth = maxWidth / boardSettingsHexDimension.getWidth();
		this.maxHexesNumberHeight = maxHeight / boardSettingsHexDimension.getHeight();

		// centralHex = new Hex(new HexPosition(0, 0, 0, new
		// CartesianPosition(150, 150)), new HexDimensions(DEFAULT_SIZE));
	}

	public Hex getCentralHex() {
		return centralHex;
	}

	/**
	 * working and painting hex board. TODO: create data structure to hold Hexes and add them coordinates at creation
	 * @param g2
	 */
	public void paintBoard(Graphics2D g2) {
		for (int i = 0; i < maxHexesNumberHeight; i++) {
			for (int j = 0; j < maxHexesNumberWidth; j++) {
				double newCenterX = ((((j+1) * boardSettingsHexDimension.getWidth() - (1 / 2D * boardSettingsHexDimension.getWidth()))
						+ (i % 2) * (1 / 2D * boardSettingsHexDimension.getWidth())));
				// double newCenterX =
				// (boardSettingsHexDimension.getWidth()*(j+1)) +50;
				// double newCenterY = (i+ (1/2D *
				// boardSettingsHexDimension.getHeight())) +50;
				double newCenterY = (((i+1) * (3/4D * boardSettingsHexDimension.getHeight()))
						- (1 / 4D * boardSettingsHexDimension.getHeight()));
				System.out.println("Current hex center will be: ("+newCenterX+", "+newCenterY+")");
				CartesianPosition hexCenter = new CartesianPosition(newCenterX, newCenterY);
				g2.drawRect((int) newCenterX, (int) newCenterY, 1, 1);
				new Hex(new HexPosition(j, i, -j-i, hexCenter), boardSettingsHexDimension.getSize()).paintComponent(g2);
			}
		}
	}
}
