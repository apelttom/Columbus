package view;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;

import controller.listeners.MainWindowKeyListener;
import model.board.HexBoard;
import model.units.GreenUnit;
import view.painter.HexPainter;

public class MainWindow extends JFrame {
	
	/**
	 * Main window containing the graphics elements of Columbus game
	 * @param args - arguments from input in command line mode
	 */
	public MainWindow(){

	}
	
	public void paint(Graphics g) {
        super.paint(g);  // fixes the immediate problem.
        Graphics2D g2 = (Graphics2D) g;
//        Line2D lin = new Line2D.Float(100, 100, 250, 260);
		HexBoard hexBoard = new HexBoard();
		for (int i = 0; i <= 5; i++) {
			int drawLineFromIndex = i;
			int drawLineToIndex = (i+1) % 6;
			g2.drawLine((int)hexBoard.getHex().getCorner(drawLineFromIndex).getX(), (int)hexBoard.getHex().getCorner(drawLineFromIndex).getY(), (int)hexBoard.getHex().getCorner(drawLineToIndex).getX(), (int)hexBoard.getHex().getCorner(drawLineToIndex).getY());
		}
//        g2.draw(lin);
    }
	
	public static void main(String[] args){
		MainWindow mainWindow = new MainWindow();
		GreenUnit greenUnit = new GreenUnit();
		MainWindowKeyListener keyListener = new MainWindowKeyListener();
		keyListener.accept(greenUnit);
		mainWindow.add(greenUnit);
		mainWindow.addKeyListener(keyListener);
		mainWindow.setSize(300, 300);
		mainWindow.setVisible(true);
	}
}
