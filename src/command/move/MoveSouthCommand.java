package command.move;

import command.wrapper.MovePositionCommandWrapper;

public class MoveSouthCommand extends MoveCommand {

	public MoveSouthCommand(MovePositionCommandWrapper wrapper) {
		super(wrapper);
	}

	@Override
	public void execute() {
		wrapper.getPosition().moveSouth(wrapper.getSpeed());
	}

}
