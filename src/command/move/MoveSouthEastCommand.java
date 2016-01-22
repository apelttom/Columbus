package command.move;

import command.wrapper.DirectionMoveParameterWrapper;

public class MoveSouthEastCommand extends MoveCommand {

	public MoveSouthEastCommand(DirectionMoveParameterWrapper wrapper) {
		super(wrapper);
	}

	@Override
	public void execute() {
		directionMoveWrapper.getPosition().moveSouthEast(directionMoveWrapper.getSpeed());
	}

}
