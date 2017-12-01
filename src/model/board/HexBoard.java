package model.board;

import java.awt.Graphics2D;
import java.util.ArrayList;

import controller.core.CartesianPosition;

public class HexBoard {

	private int userDefinedHexSize = -1;
	private HexDimensions boardSettingsHexDimension;
	// unused now -> delete?
	private int boardSettingsWidth;
	private int boardSettingsHeight;
	private int maxHexesColumns;
	private int maxHexesRows;
	// private ArrayList<ArrayList<Hex>> boardMap;
	private ArrayList<ArrayList<Hex>> boardDataStructure;
	private int boardDataStructureColumns;

	public static final int DEFAULT_SIZE = 24;

	/**
	 * Used for creation of the rectangle shaped hexagon board
	 * 
	 * @param boardWidth
	 * @param boardHeight
	 */
	public HexBoard(int boardWidth, int boardHeight) {
		// if user have not defined Hex dimension, engine use the
		// default one
		if (this.userDefinedHexSize == -1) {
			this.boardSettingsHexDimension = new HexDimensions(DEFAULT_SIZE);
		} else {
			this.boardSettingsHexDimension = new HexDimensions(this.userDefinedHexSize);
		}
		this.boardSettingsWidth = boardWidth;
		this.boardSettingsHeight = boardHeight;
		// it is easy to calculate number of hexagons in rows, because hexagons
		// are side by side in row
		this.maxHexesColumns = (int) (boardWidth / (double) boardSettingsHexDimension.getWidth());

		/**
		 * a little harder it is in case of rows to be able to count number of
		 * hexagons in rows correctly, we have to particle the height space
		 * equally with a fixed number of hexagons the least "tile" such as
		 * described previously is of the size of 21 quarters of the hexagon
		 * height if you choose lesser, you will be medling with beginning or
		 * end of another hexagon row, but if you count 21 quarters, you get
		 * exactly 7 hexagons in row and you can start from the beginning it
		 * reminds modulo 21 in a world where rest is not 0, but 7
		 * See https://www.redblobgames.com/grids/hexagons/#basics
		 */
		double rowTileWithFixedNumberOfHexes = (21 / 4D * boardSettingsHexDimension.getHeight());
		double numberOfRowTiles = boardHeight / rowTileWithFixedNumberOfHexes;
		this.maxHexesRows = (int) (numberOfRowTiles * 7);

		int numberOfDataStructureNegativeColumns;
		 if(maxHexesRows % 2 == 0){
			 numberOfDataStructureNegativeColumns = (maxHexesRows / 2) - 1;
			 boardDataStructureColumns = maxHexesColumns + numberOfDataStructureNegativeColumns;
		 } else {
			 numberOfDataStructureNegativeColumns = (maxHexesRows / 2);
			 boardDataStructureColumns = maxHexesColumns + numberOfDataStructureNegativeColumns;
		 }
		 int maxBoardDataStructureColumnSize = maxHexesRows;

		// ArrayList<ArrayList<Hex>>(boardModelTableColumns);
		 
		boardDataStructure = new ArrayList<ArrayList<Hex>>(boardDataStructureColumns);
		System.out.print("Column lengths from the left: ");
		for (int i = (0 - numberOfDataStructureNegativeColumns); i < 1; i++) {
//			we have to precalculate how big the column in the data structure will be
//			this can be done if we will use an offset from the beginning and the end of the data structure that will tell us where full columns start and where it ends
//			we surely know that 0 will be the first column which has full size, in that case it transforms our question into: where is the 0 column located in the data structure?
//			we have to calculate how many columns are there before 0 -> nubmer of rows divided by two, because new data structure column starts every second row (first is the start, second is the continuation)
//			so the number of minus columns will be maxHexesRows / 2 or (maxHexesRows/2)-1 if maxHexesRows is even (we should not calculate 0 row on the beginning)
//			starting from there we will calculate the length of the current column based on how far it is from 0 column
//			each step out of the 0 column to the left (into negative numbers) means substracting 2 from the maximal length of the data structure column
//			using this approach we are able to hang the calculation on the negative index
//			to do that we have to create for cycle form the most left negative index up to 0 (and farther)
			
			int currentColumnLength = maxBoardDataStructureColumnSize - Math.abs(i * 2);
			boardDataStructure.add(new ArrayList<Hex>(currentColumnLength));
			System.out.print(currentColumnLength + ", ");
		}
		System.out.println();

		// System.out.println("Data structure size" + boardDataStructureSize);

		
		for (int i = 0; i < maxHexesRows; i = i + 1) {
			for (int j = 0; j < maxHexesColumns; j = j + 1) {
				double newCenterX = ((((j + 1) * boardSettingsHexDimension.getWidth()
						- (1 / 2D * boardSettingsHexDimension.getWidth()))
						+ (i % 2) * (1 / 2D * boardSettingsHexDimension.getWidth())));
				double newCenterY = (((i + 1) * (3 / 4D * boardSettingsHexDimension.getHeight()))
						- (1 / 4D * boardSettingsHexDimension.getHeight()));
				CartesianPosition hexCenter = new CartesianPosition(newCenterX, newCenterY);
				boardDataStructure.get(numberOfDataStructureNegativeColumns)
						.add(new Hex(new HexPosition(j, i, (-j - i), hexCenter), boardSettingsHexDimension.getSize()));
			}
		}
	}

	/**
	 * painting the board works like charm. TODO: is time to create a proper
	 * data structure to hold the hexes
	 * 
	 * @param g2
	 */
	public void paintBoard(Graphics2D g2) {
		for (ArrayList<Hex> arrayList : boardDataStructure) {
			for (Hex hex : arrayList) {
				hex.paintComponent(g2);
				g2.drawString(hex.getHexPosition().getX() + ", " + hex.getHexPosition().getY(),
						(float) hex.getHexPosition().getHexCenter().getX(),
						(float) hex.getHexPosition().getHexCenter().getY());
			}
		}
		// g2.drawRect((int) newCenterX, (int) newCenterY, 1, 1);
	}
}
