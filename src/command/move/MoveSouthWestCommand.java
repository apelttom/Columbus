package command.move;

import command.wrapper.DirectionMoveParameterWrapper;

public class MoveSouthWestCommand extends MoveCommand {

	public MoveSouthWestCommand(DirectionMoveParameterWrapper wrapper) {
		super(wrapper);
	}

	@Override
	public void execute() {
		directionMoveWrapper.getPosition().moveSouthWest(directionMoveWrapper.getSpeed());
	}

}
