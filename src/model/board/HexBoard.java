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
	 * a little harder it is in case of rows to be able to count number of hexagons in rows
	 * correctly, we have to particle the height space equally with a fixed number of hexagons
	 * the least "tile" such as described previously is of the size of 21 quarters of the
	 * hexagon height if you choose lesser, you will be medling with beginning or end of another
	 * hexagon row, but if you count 21 quarters, you get exactly 7 hexagons in row and you can
	 * start from the beginning it reminds modulo 21 in a world where rest is not 0, but 7 See
	 * https://www.redblobgames.com/grids/hexagons/#basics
	 */
	double rowTileWithFixedNumberOfHexes = (21 / 4D * boardSettingsHexDimension.getHeight());
	double numberOfRowTiles = boardHeight / rowTileWithFixedNumberOfHexes;
	this.maxHexesRows = (int) (numberOfRowTiles * 7);

	/**
	 * We will have to hold the Hexagon Board in some data structure. Two-dimensional array is usable for
	 * this task, but we will have to modify it a little bit in order to get the most out of the system performance.
	 * 
	 * 1. We will use ArrayList and not Hash table as ArrayList is faster (no need for hash calculation)
	 * 2. We will eliminate empty space we would possibly allocate if we would go for all columns of the array of the same length
	 * 3. To calculate each array length separately, we need to identify which arrays are fully filled and which are not
	 * 
	 * Data structure will look like this (0 - empty, 1 - filled):
	 * 
	 * 	index: -2 -1  0  1  2  3  4  5
	 * 
	 *	shape:	1  1  1  1  1  1  1  1
	 * 			1  1  1  1  1  1  1  1
	 * 			0  1  1  1  1  1  1  0
	 * 			0  1  1  1  1  1  1  0
	 * 			0  0  1  1  1  1  0  0
	 * 			0  0  1  1  1  1  0  0
	 * 
	 * See https://www.redblobgames.com/grids/hexagons/#map-storage
	 */
	
	// we need to calculate number of not fully filled columns on the left and on the right
	int dataStructNumOfPartialFilledColumns;

	/**
	 * How many columns in the data structure are there before index 0?
	 * 
	 * [number of Hexagon rows / 2] because new data structure column starts every second row -
	 * first row is the beginning of the data structure column, second is the continuation.
	 * 
	 * The number of partially filled columns will be:
	 * 
	 * maxHexesRows / 2
	 * 
	 * or
	 * 
	 * (maxHexesRows/2)-1 if maxHexesRows is even (we should not calculate 0 row on the
	 * beginning)
	 * 
	 * Starting from there we will calculate the length of the current column based on how far
	 * it is from the 0 column, each step out of the 0 column to the left (into negative
	 * numbers) means subtracting 2 from the maximal length of the data structure column using
	 * this approach we are able to hang the calculation on the negative index to do that we
	 * have to create for cycle form the most left negative index up to 0 (and farther)
	 * 
	 * Same number of columns holds for the last partially filled columns in the right * See
	 * https://www.redblobgames.com/grids/hexagons/#map-storage
	 */

	if (maxHexesRows % 2 == 0) {
	    dataStructNumOfPartialFilledColumns = (maxHexesRows / 2) - 1;
	    boardDataStructureColumns = maxHexesColumns + dataStructNumOfPartialFilledColumns;
	} else {
	    dataStructNumOfPartialFilledColumns = (maxHexesRows / 2);
	    boardDataStructureColumns = maxHexesColumns + dataStructNumOfPartialFilledColumns;
	}

	// the length of data structure column will be max number of hexagon rows
	int dataStructMaxColumnSize = maxHexesRows;
	/**
	 * first fully filled data structure column will be the one at the index 0, but the index of
	 * the last fully filled column has to be calculated as:
	 * 
	 * Index = NumberOfAllColumns - NumberOfLeftPartiallyFilledColumns -
	 * NumberOfRightPartiallyFilledColumns Index = Index - 1 -> because we are indexing using
	 * zero
	 */
	int dataStructIndexOfLastFullColumn = boardDataStructureColumns - dataStructNumOfPartialFilledColumns
		- dataStructNumOfPartialFilledColumns - 1;

	// number of all columns is clear - that will be one dimension
	boardDataStructure = new ArrayList<ArrayList<Hex>>(boardDataStructureColumns);

	int beginningIndex = 0 - dataStructNumOfPartialFilledColumns;
	int endIndex = boardDataStructureColumns - dataStructNumOfPartialFilledColumns;
	
	/**
	 * Iterating through all data structure columns we are able to calculate each column length
	 * on the fly
	 */
	for (int dataStructIndex = beginningIndex, m = 0; dataStructIndex < endIndex; dataStructIndex++, m++) {
	    if (dataStructIndex < 1) {
		int currentColumnLength = dataStructMaxColumnSize - Math.abs(dataStructIndex * 2);
		boardDataStructure.add(new ArrayList<Hex>(currentColumnLength));
		for (int j = 0; j < currentColumnLength; j++) {
		    createHexagon(dataStructIndex,j,m);
		}
	    } else if (dataStructIndex < dataStructIndexOfLastFullColumn) {
		boardDataStructure.add(new ArrayList<Hex>(dataStructMaxColumnSize));
		for (int j = 0; j < dataStructMaxColumnSize; j++) {
		    createHexagon(dataStructIndex,j,m);
		}
	    } else {
		int currentColumnLength = dataStructMaxColumnSize - Math.abs((dataStructIndexOfLastFullColumn - dataStructIndex) * 2);
		boardDataStructure.add(new ArrayList<Hex>(currentColumnLength));
		for (int j = 0; j < currentColumnLength; j++) {
		    createHexagon(dataStructIndex,j,m);
		}
	    }
	}

//	for (int i = 0; i < maxHexesRows; i = i + 1) {
//	    for (int j = 0; j < maxHexesColumns; j = j + 1) {
//		double newCenterX = ((((j + 1) * boardSettingsHexDimension.getWidth()
//			- (1 / 2D * boardSettingsHexDimension.getWidth()))
//			+ (i % 2) * (1 / 2D * boardSettingsHexDimension.getWidth())));
//		double newCenterY = (((i + 1) * (3 / 4D * boardSettingsHexDimension.getHeight()))
//			- (1 / 4D * boardSettingsHexDimension.getHeight()));
//		CartesianPosition hexCenter = new CartesianPosition(newCenterX, newCenterY);
//		boardDataStructure.get(dataStructNumOfPartialFilledColumns)
//			.add(new Hex(new HexPosition(j, i, (-j - i), hexCenter), boardSettingsHexDimension.getSize()));
//	    }
//	}

	System.out.print("Length of the arrayLists: ");
	// testing the data structure
	for (ArrayList<Hex> arrayList : boardDataStructure) {
	    System.out.print(arrayList.size() + ", ");
	}
	
    }
    
    private void createHexagon(int x, int y, int dataStructColumnIndex){
	double newCenterX = ((((x + 1) * boardSettingsHexDimension.getWidth()
		- (1 / 2D * boardSettingsHexDimension.getWidth()))
		+ (x % 2) * (1 / 2D * boardSettingsHexDimension.getWidth())));
	double newCenterY = (((y + 1) * (3 / 4D * boardSettingsHexDimension.getHeight()))
		- (1 / 4D * boardSettingsHexDimension.getHeight()));
	CartesianPosition hexCenter = new CartesianPosition(newCenterX, newCenterY);
	boardDataStructure.get(dataStructColumnIndex)
		.add(new Hex(new HexPosition(x, y, (-x - y), hexCenter), boardSettingsHexDimension.getSize()));
    }

    /**
     * painting the board works like charm.
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
