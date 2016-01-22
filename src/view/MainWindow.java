package view;

import javax.swing.JFrame;

import controller.listeners.MainWindowKeyListener;
import model.units.GreenUnit;

public class MainWindow {
	

	static JFrame mainWindow;
	
	/**
	 * Main window containing the graphics elements of Columbus game
	 * @param args - arguments from input in command line mode
	 */
	public static void main(String[] args){
		GreenUnit greenUnit = new GreenUnit();
		MainWindowKeyListener keyListener = new MainWindowKeyListener();
		keyListener.accept(greenUnit);
		mainWindow = new JFrame("Columbus");
		mainWindow.add(greenUnit);
		mainWindow.addKeyListener(keyListener);
		mainWindow.setSize(300, 300);
		mainWindow.setVisible(true);
	}
}
