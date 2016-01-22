package command.move;

import command.wrapper.DirectionMoveParameterWrapper;

public class MoveNorthWestCommand extends MoveCommand {

	public MoveNorthWestCommand(DirectionMoveParameterWrapper wrapper) {
		super(wrapper);
	}

	@Override
	public void execute() {
		directionMoveWrapper.getPosition().moveNorthWest(directionMoveWrapper.getSpeed());
	}

}
