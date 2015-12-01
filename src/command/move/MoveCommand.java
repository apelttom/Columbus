package command.move;

import command.Command;
import command.wrapper.MovePositionCommandWrapper;

public abstract class MoveCommand implements Command {

	protected MovePositionCommandWrapper wrapper;
	
	protected MoveCommand(MovePositionCommandWrapper wrapper) {
		this.wrapper = wrapper;
	}
	
	@Override
	public abstract void execute();

}
