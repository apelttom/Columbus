package units;

import core.Position;
import core.PositionController;
import core.interfaces.IVisitorPatternVisitor;
import gui.GraphicModel;
import model.Direction;
import model.MovementSpeed;

/**
 * Simple unit used for testing logic and graphic
 * @author tapeltauer
 *
 */
public class GreenUnit extends Unit implements IVisitorPatternVisitor {

	/**
	 * Serial Version UI
	 */
	private static final long serialVersionUID = 6668619930035425813L;

	public GreenUnit() {
		graphicModel = new GraphicModel("graphics/greenUnit.png");
		movementSpeed = new MovementSpeed();
		position = new Position();
	}
	
	@Override
	public boolean move(Direction.Course course) {
		if(PositionController.getInstance().movePosition(position, course, movementSpeed)){
			paintComponent(getGraphics());
			getRootPane().repaint();
			return true;
		}
		return false;
	}

	@Override
	public boolean attack(Unit target) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void visit(Direction.Course course) {
		move(course);		
	}

}
