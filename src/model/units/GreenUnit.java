package model.units;

import controller.core.CartesianPosition;
import controller.core.PositionController;
import controller.interfaces.IVisitableUnit;
import model.Direction;
import model.MovementSpeed;
import view.GraphicModel;

/**
 * Simple unit used for testing logic and graphic
 * @author tapeltauer
 *
 */
public class GreenUnit extends Unit implements IVisitableUnit {

	/**
	 * Serial Version UI
	 */
	private static final long serialVersionUID = 6668619930035425813L;
	private static final UnitPosition DEFAULT_UNIT_POSITION = new UnitPosition(10, 10);

	public GreenUnit() {
		graphicModel = new GraphicModel("graphics/greenUnit.png");
		movementSpeed = new MovementSpeed();
		position = DEFAULT_UNIT_POSITION;
	}
	
	@Override
	protected boolean move(Direction.Course course) {
		if(PositionController.getInstance().movePosition(position, course, movementSpeed)){
			paintComponent(getGraphics());
			getRootPane().repaint();
			return true;
		}
		return false;
	}
	
	protected boolean move(CartesianPosition position){
		if(PositionController.getInstance().movePosition(this.position, position, movementSpeed)){
			paintComponent(getGraphics());
			getRootPane().repaint();
			return true;
		}
		return false;
	}

	@Override
	protected boolean attack(Unit target) {
		// TODO: Create attack logic
		return false;
	}

	@Override
	public void visit(CartesianPosition position) {
		move(position);		
	}

	@Override
	public void visit(Direction.Course course) {
		move(course);		
	}
}
