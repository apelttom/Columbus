package view;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;

import controller.listeners.MainWindowKeyListener;
import model.board.HexBoard;
import model.units.GreenUnit;

public class MainWindow extends JFrame {
	
	private static final long serialVersionUID = 952738263991002651L;

	/**
	 * Main window containing the graphics elements of Columbus game
	 * @param args - arguments from input in command line mode
	 */
	public MainWindow(){

	}
	
	public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
		HexBoard hexBoard = new HexBoard(this.getWidth(), this.getHeight());
		hexBoard.paintBoard(g2);
		
		/*
		 * This part serves as visual representation of the the diagonal directions 
        double axeXmiddle = this.getHeight()/2;
        double axeYmiddle = this.getWidth()/2;
        CartesianPosition middle = new CartesianPosition(axeXmiddle, axeYmiddle);
        g2.drawLine(0, (int) axeYmiddle, this.getWidth(), (int) axeYmiddle);
        g2.drawLine((int) axeXmiddle, 0, (int) axeXmiddle, this.getHeight());
        // change 120 to another multiple by 60 and you get another diagonal direction
        double vector_rad = Math.PI / 180 * 120;
        double newXpoint = axeXmiddle + Math.cos(vector_rad) * 40;
        double newYpoint = axeYmiddle + Math.sin(vector_rad) * 40;
        System.out.println(newXpoint);
        System.out.println(newYpoint);
        g2.drawLine((int) axeXmiddle, (int) axeYmiddle, (int) newXpoint, (int) newYpoint);
         */
    }
	
	public static void main(String[] args){
		MainWindow mainWindow = new MainWindow();
//		GreenUnit greenUnit = new GreenUnit();
//		MainWindowKeyListener keyListener = new MainWindowKeyListener();
//		keyListener.accept(greenUnit);
//		mainWindow.add(greenUnit);
//		mainWindow.addKeyListener(keyListener);
		mainWindow.setSize(330, 213);
		mainWindow.setVisible(true);
	}
}
