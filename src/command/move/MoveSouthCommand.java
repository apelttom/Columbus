package command.move;

import command.wrapper.DirectionMoveParameterWrapper;

public class MoveSouthCommand extends MoveCommand {

	public MoveSouthCommand(DirectionMoveParameterWrapper wrapper) {
		super(wrapper);
	}

	@Override
	public void execute() {
		directionMoveWrapper.getPosition().moveSouth(directionMoveWrapper.getSpeed());
	}

}
