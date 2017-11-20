package model.board;

import java.awt.Graphics2D;
import java.util.ArrayList;

import controller.core.CartesianPosition;

public class HexBoard {

	private Hex centralHex;
	private int userDefinedHexSize = -1;
	private HexDimensions boardSettingsHexDimension;
	private int maxHexesColumns;
	private int maxHexesRows;
	private ArrayList<ArrayList<Hex>> boardMap;
	private int boardMapColumns;

	public static final int DEFAULT_SIZE = 30;

	public HexBoard(int maxWidth, int maxHeight) {
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
		/**
		 * As pictured in https://www.redblobgames.com/grids/hexagons/#basics first we calculate how many
		 * "tiles" can be put on the board. One tile contains 2x2 hexes. Next we multiply by two in order to
		 * discover the real maximal amount of hexes that would fit into board
		 * 
		 *  TODO: try different approach, this is not gonna work well, the error is cumulating
		 *  maybe if you would check that hex is not gonna cross the line of the border for every generated hex. That should do.
		 *  Then move the logic of board Hex rows and columns to the generator part
		 *  
		 *  Even better! check if there can be more hexes only when the last one hex is created!
		 */
		double maxColumnsHexTiles = maxWidth / ((5/2D) * boardSettingsHexDimension.getWidth());
		this.maxHexesColumns = (int) (maxColumnsHexTiles * 2D);
		double maxRowsHexTiles = maxHeight / ((7/4D) * boardSettingsHexDimension.getHeight());
//		TODO: this round is not propper. There should be rounding base on the tile percantage of hex
		this.maxHexesRows = (int) Math.round(maxRowsHexTiles * 2D);
//		TODO: this round is not propper. There should be rounding base on the tile percantage of hex		
		this.boardMapColumns = (int) Math.round(maxHexesColumns + (maxHexesRows / 2));
//		this.board = new ArrayList<new ArrayList<Hex>()>();

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
		for (int i = 0; i < maxHexesRows; i++) {
			for (int j = 0; j < maxHexesColumns; j++) {
				double newCenterX = ((((j+1) * boardSettingsHexDimension.getWidth() - (1 / 2D * boardSettingsHexDimension.getWidth()))
						+ (i % 2) * (1 / 2D * boardSettingsHexDimension.getWidth())));
				// double newCenterX =
				// (boardSettingsHexDimension.getWidth()*(j+1)) +50;
				// double newCenterY = (i+ (1/2D *
				// boardSettingsHexDimension.getHeight())) +50;
				double newCenterY = (((i+1) * (3/4D * boardSettingsHexDimension.getHeight()))
						- (1 / 4D * boardSettingsHexDimension.getHeight()));
				CartesianPosition hexCenter = new CartesianPosition(newCenterX, newCenterY);
				g2.drawRect((int) newCenterX, (int) newCenterY, 1, 1);
				new Hex(new HexPosition(j, i, -j-i, hexCenter), boardSettingsHexDimension.getSize()).paintComponent(g2);
			}
		}
	}
}
