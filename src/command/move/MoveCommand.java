package command.move;

import command.Command;
import command.wrapper.DirectionMoveParameterWrapper;

public abstract class MoveCommand implements Command {

	protected DirectionMoveParameterWrapper directionMoveWrapper;
	
	protected MoveCommand(DirectionMoveParameterWrapper wrapper) {
		this.directionMoveWrapper = wrapper;
	}
	
	@Override
	public abstract void execute();

}
