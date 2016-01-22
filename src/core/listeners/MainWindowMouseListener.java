package core.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import core.Position;
import core.interfaces.IVisitableUnit;
import core.interfaces.IVisitor;

public class MainWindowMouseListener implements MouseListener, IVisitor {

	private List<IVisitableUnit> visitables;
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
//		TODO: fix
//		Position
//		visit(arg0.getX(),arg0.getY());
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void accept(IVisitableUnit visitor) {
		if (visitables == null) {
			visitables = new ArrayList<>();
		}
		visitables.add(visitor);
	}
	private void visit(Position position) {
		if (visitables != null) {
			for (IVisitableUnit visitable : visitables) {
				visit(position);
			}
		}
	}
}
