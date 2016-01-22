package command.move;

import command.wrapper.DirectionMoveParameterWrapper;

public class MoveNorthCommand extends MoveCommand{

	public MoveNorthCommand(DirectionMoveParameterWrapper wrapper) {
		super(wrapper);
	}
	
	@Override
	public void execute() {
		directionMoveWrapper.getPosition().moveNorth(directionMoveWrapper.getSpeed());	
	}

}
