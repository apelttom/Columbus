package core.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import core.interfaces.IVisitorPatternElement;
import core.interfaces.IVisitorPatternVisitor;
import model.Direction;

public class MainWindowKeyListener implements KeyListener, IVisitorPatternElement {

	private List<IVisitorPatternVisitor> visitables;

	@Override
	public void keyPressed(KeyEvent arg0) {
		int keyCode = arg0.getKeyCode();
		switch (keyCode) {
		case KeyEvent.VK_W:
			visit(Direction.Course.NORTH);
			break;
		case KeyEvent.VK_S:
			visit(Direction.Course.SOUTH);
			break;
		case KeyEvent.VK_A:
			visit(Direction.Course.WEST);
			break;
		case KeyEvent.VK_D:
			visit(Direction.Course.EAST);
			break;
		default:
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void accept(IVisitorPatternVisitor visitor) {
		if (visitables == null) {
			visitables = new ArrayList<>();
		}
		visitables.add(visitor);
	}

	private void visit(Direction.Course course) {
		if (visitables != null) {
			for (IVisitorPatternVisitor visitable : visitables) {
				visitable.visit(course);
			}
		}
	}

}
