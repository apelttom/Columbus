package command.move;

import command.wrapper.MovePositionCommandWrapper;

public class MoveEastCommand extends MoveCommand {

	public MoveEastCommand(MovePositionCommandWrapper wrapper) {
		super(wrapper);
	}

	@Override
	public void execute() {
		wrapper.getPosition().moveEast(wrapper.getSpeed());
	}

}
