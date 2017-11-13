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
		g2.drawLine((int)hexBoard.getHex().getCorner(5).getX(), (int)hexBoard.getHex().getCorner(5).getY(), (int)hexBoard.getHex().getCorner(0).getX(), (int)hexBoard.getHex().getCorner(0).getY());
		for (int i = 0; i < 5; i++) {
			g2.drawLine((int)hexBoard.getHex().getCorner(i).getX(), (int)hexBoard.getHex().getCorner(i).getY(), (int)hexBoard.getHex().getCorner(i+1).getX(), (int)hexBoard.getHex().getCorner(i+1).getY());
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
