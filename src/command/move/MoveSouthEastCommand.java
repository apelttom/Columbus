package command.move;

import command.wrapper.MovePositionCommandWrapper;

public class MoveSouthEastCommand extends MoveCommand {

	public MoveSouthEastCommand(MovePositionCommandWrapper wrapper) {
		super(wrapper);
	}

	@Override
	public void execute() {
		wrapper.getPosition().moveSouthEast(wrapper.getSpeed());
	}

}
