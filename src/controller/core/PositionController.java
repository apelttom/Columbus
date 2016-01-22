package controller.core;

import command.Command;
import command.MoveInDirectionCommandFactory;
import command.wrapper.ChangeFacingCommandWrapper;
import command.wrapper.DirectionMoveParameterWrapper;
import model.Direction;
import model.Speed;
import model.units.UnitPosition;

/**
 * Based on type of the action invoked by switch in Position does the logic.
 * @author tapeltauer
 * @param <T>
 *
 */
public class PositionController {

	private static final Object lock = new Object();
	private static PositionController instance;
	private static MoveInDirectionCommandFactory commandFactory;

	private PositionController(){
		commandFactory = new MoveInDirectionCommandFactory();
	}

	public static PositionController getInstance() {
		PositionController obj = instance;
		if (obj == null) {
			synchronized (lock) { // While we were waiting for the lock, another
				obj = instance; // thread may have instantiated the object.
				if (obj == null) {
					obj = new PositionController();
					instance = obj;
				}
			}
		}
		return obj;
	}
	
	public boolean movePosition(UnitPosition start, CartesianPosition end, Speed movementSpeed) {
//		Command command = commandFactory.getCommand(start, end, new MovePositionCommandWrapper(end, movementSpeed));
		return true;
	}
	
	public boolean movePosition(UnitPosition position, Direction.Course course, Speed speed) {
		Command command = commandFactory.createCommand(new DirectionMoveParameterWrapper(position, speed, course));
		try {
			command.execute();
//			TODO: Write the proper exception if movement is not possible
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public boolean changeFacing(UnitPosition position, Direction.Course course) {
		//TODO: fix asap. Needed?
		Command command = commandFactory.createCommand(new ChangeFacingCommandWrapper(position));
		executeCommand(command);
		return true;
	}

	private void executeCommand(Command command) {
		try {
			command.execute();
//			TODO: Write the proper exception if movement is not possible
		} catch (Exception e) {
			System.err.println("Command execution has failed!");
			e.printStackTrace();
		}
	}

}