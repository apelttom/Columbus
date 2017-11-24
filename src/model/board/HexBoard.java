package model.board;

import java.awt.Graphics2D;
import java.util.ArrayList;

import controller.core.CartesianPosition;

public class HexBoard {

	private int userDefinedHexSize = -1;
	private HexDimensions boardSettingsHexDimension;
//	unused now -> delete?
	private int boardSettingsWidth;
	private int boardSettingsHeight;
	private int maxHexesColumns;
	// private ArrayList<ArrayList<Hex>> boardMap;
	private ArrayList<Hex> boardMap;

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

		// engine is able to calculate how many columns of hexes it will need
		double correctedBoardWidth = boardWidth - (1 / 2D * boardSettingsHexDimension.getWidth());
		this.maxHexesColumns = (int) (correctedBoardWidth / (double) boardSettingsHexDimension.getWidth());

		boardMap = new ArrayList<Hex>();

		/*
		 * due to the loss of precision engine is not able to calculate precise
		 * number of rows and have to stop creating them when it touches the
		 * border. First we check if the new Y position of next Hex would not
		 * cross the border of the maximum board height (after a small
		 * correction). More info on https://www.redblobgames.com/grids/hexagons/#basics
		 */
		for (int i = 0;; i = i + 1) {
			double newCenterY = (((i + 1) * (3 / 4D * boardSettingsHexDimension.getHeight()))
					- (1 / 4D * boardSettingsHexDimension.getHeight()));
			double limitPointForY = boardSettingsHeight - (1 / 2D * boardSettingsHexDimension.getHeight());
			if (newCenterY > limitPointForY) {
				break;
			}
			for (int j = 0; j < maxHexesColumns; j = j + 1) {
				double newCenterX = ((((j + 1) * boardSettingsHexDimension.getWidth()
						- (1 / 2D * boardSettingsHexDimension.getWidth()))
						+ (i % 2) * (1 / 2D * boardSettingsHexDimension.getWidth())));
				CartesianPosition hexCenter = new CartesianPosition(newCenterX, newCenterY);
				boardMap.add(new Hex(new HexPosition(j, i, (-j - i), hexCenter),
						boardSettingsHexDimension.getSize()));
			}
		}
//		System.out.println("Num of hexes: " + boardMap.size());
	}

	/**
	 * painting the board works like charm.
	 * TODO: is time to create a proper data structure to hold the hexes
	 * 
	 * @param g2
	 */
	public void paintBoard(Graphics2D g2) {
		for (Hex hex : boardMap) {
			hex.paintComponent(g2);
		}
		// g2.drawRect((int) newCenterX, (int) newCenterY, 1, 1);
	}
}
