package gui;

import javax.swing.ImageIcon;

public class GraphicModel {

	private ImageIcon unitImage;
	
	public GraphicModel(String pathVisual) {
		unitImage = new ImageIcon(pathVisual);		
	}

	public ImageIcon getUnitImage() {
		return unitImage;
	}

	public void setUnitImage(ImageIcon unitImage) {
		this.unitImage = unitImage;
	}
	
	
}
