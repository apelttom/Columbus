package model.units;

import java.awt.Graphics;

import javax.swing.JComponent;

import controller.core.CartesianPosition;
import model.Direction;
import model.Health;
import model.MovementSpeed;
import model.SpaceVolume;
import model.Strength;
import view.GraphicModel;

public abstract class Unit extends JComponent {

	/**
	 * Serial UI
	 */
	private static final long serialVersionUID = 3454058457806189513L;

	GraphicModel graphicModel = null;
	Health health = null;
	Strength strength = null;
	UnitPosition position = null;
	MovementSpeed movementSpeed = null;
	SpaceVolume spaceVolume = null;

	protected abstract boolean move(Direction.Course course);
	
	protected abstract boolean move(CartesianPosition position);

	protected abstract boolean attack(Unit target);

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		graphicModel.getUnitImage().paintIcon(this, g, position.getX(), position.getY());
	}
}
