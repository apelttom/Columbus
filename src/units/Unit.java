package units;

import java.awt.Graphics;

import javax.swing.JComponent;

import core.Position;
import gui.GraphicModel;
import model.Direction;
import model.Health;
import model.MovementSpeed;
import model.SpaceVolume;
import model.Strength;

public abstract class Unit extends JComponent {

	/**
	 * Serial UI
	 */
	private static final long serialVersionUID = 3454058457806189513L;

	GraphicModel graphicModel = null;
	Health health = null;
	Strength strength = null;
	Position position = null;
	MovementSpeed movementSpeed = null;
	SpaceVolume spaceVolume = null;

	abstract boolean move(Direction.Course course);

	abstract boolean attack(Unit target);

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		graphicModel.getUnitImage().paintIcon(this, g, position.getX(), position.getY());
	}
}
