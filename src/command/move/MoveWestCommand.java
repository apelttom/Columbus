package command.move;

import command.wrapper.DirectionMoveParameterWrapper;

public class MoveWestCommand extends MoveCommand {

	public MoveWestCommand(DirectionMoveParameterWrapper wrapper) {
		super(wrapper);
	}

	@Override
	public void execute() {
		directionMoveWrapper.getPosition().moveWest(directionMoveWrapper.getSpeed());
	}

}
