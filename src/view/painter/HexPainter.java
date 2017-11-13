package view.painter;

import javax.swing.JFrame;

import model.board.Hex;

public class HexPainter {

	public static void paintHex(JFrame canvas, Hex hex){
		canvas.getGraphics().drawLine((int)hex.getCorner(0).getX(), (int)hex.getCorner(0).getY(), (int)hex.getCorner(1).getX(), (int)hex.getCorner(1).getY());
		System.out.println((int)hex.getCorner(0).getX());
		System.out.println((int)hex.getCorner(0).getY());
		System.out.println((int)hex.getCorner(1).getX());
		System.out.println((int)hex.getCorner(1).getY());
	}
}
