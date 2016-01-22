package core.interfaces;

import core.Position;
import model.Direction;

/**
 * TODO: find out how pattern visitor works and possibly create VisitorFactory
 * 
 * @author tapeltauer
 *
 */
public interface IVisitableUnit {

	public void visit(Position position);
	public void visit(Direction.Course course);
}
