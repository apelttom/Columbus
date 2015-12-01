package command.move;

import command.wrapper.MovePositionCommandWrapper;

public class MoveSouthWestCommand extends MoveCommand {

	public MoveSouthWestCommand(MovePositionCommandWrapper wrapper) {
		super(wrapper);
	}

	@Override
	public void execute() {
		wrapper.getPosition().moveSouthWest(wrapper.getSpeed());
	}

}
