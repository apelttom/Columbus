package command.move;

import command.wrapper.DirectionMoveParameterWrapper;

public class MoveNorthEastCommand  extends MoveCommand {

	public MoveNorthEastCommand(DirectionMoveParameterWrapper wrapper) {
		super(wrapper);
	}

	@Override
	public void execute() {
		directionMoveWrapper.getPosition().moveNorthEast(directionMoveWrapper.getSpeed());
	}

}
