package core.interfaces;

import core.Position;

/**
 * TODO: find out how pattern visitor works and possibly create VisitorFactory
 * 
 * @author tapeltauer
 *
 */
public interface IVisitableUnit {

	public void visit(Position position);
}
