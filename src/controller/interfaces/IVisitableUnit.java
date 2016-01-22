package controller.interfaces;

import controller.core.CartesianPosition;
import model.Direction;

/**
 * TODO: find out how pattern visitor works and possibly create VisitorFactory
 * 
 * @author tapeltauer
 *
 */
public interface IVisitableUnit {

	public void visit(CartesianPosition position);
	public void visit(Direction.Course course);
}
