package core;

import command.Command;
import command.CommandFactory;
import command.wrapper.ChangeFacingCommandWrapper;
import command.wrapper.MovePositionCommandWrapper;
import model.Direction;
import model.MovementSpeed;
import model.Speed;
import units.UnitPosition;

/**
 * Based on type of the action invoked by switch in Position does the logic.
 * @author tapeltauer
 * @param <T>
 *
 */
public class PositionController {

	private static final Object lock = new Object();
	private static PositionController instance;
	private static CommandFactory commandFactory;

	private PositionController(){
		commandFactory = new CommandFactory();
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
	
	public boolean movePosition(UnitPosition start, Position end, MovementSpeed movementSpeed) {
		Command command = commandFactory.getCommand(start, end, new MovePositionCommandWrapper(end, speed));
	}
	
	public boolean movePosition(UnitPosition position, Direction.Course course, Speed speed) {
		Command command = commandFactory.getCommand(course, new MovePositionCommandWrapper(position, speed));
		try {
			command.execute();
//			TODO: Write the proper exception if movement is not possible
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public boolean changeFacing(UnitPosition position, Direction.Course course) {
		Command command = commandFactory.getCommand(course, new ChangeFacingCommandWrapper(position));
		executeCommand(command);
		return true;
	}

	private void executeCommand(Command command) {
		try {
			command.execute();
//			TODO: Write the proper exception if movement is not possible
		} catch (Exception e) {
			System.err.println("Moving command failed!");
			e.printStackTrace();
		}
	}

}