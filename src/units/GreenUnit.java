package units;

import core.Position;
import core.PositionController;
import core.interfaces.IVisitableUnit;
import gui.GraphicModel;
import model.Direction;
import model.MovementSpeed;

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

	public GreenUnit() {
		graphicModel = new GraphicModel("graphics/greenUnit.png");
		movementSpeed = new MovementSpeed();
		position = new UnitPosition();
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
	
	protected boolean move(Position position){
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
	public void visit(Position position) {
		move(position);		
	}

}
