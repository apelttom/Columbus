package command.move;

import command.wrapper.DirectionMoveParameterWrapper;

public class MoveEastCommand extends MoveCommand {

	public MoveEastCommand(DirectionMoveParameterWrapper wrapper) {
		super(wrapper);
	}

	@Override
	public void execute() {
		directionMoveWrapper.getPosition().moveEast(directionMoveWrapper.getSpeed());
	}

}
