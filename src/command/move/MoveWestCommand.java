package command.move;

import command.wrapper.MovePositionCommandWrapper;

public class MoveWestCommand extends MoveCommand {

	public MoveWestCommand(MovePositionCommandWrapper wrapper) {
		super(wrapper);
	}

	@Override
	public void execute() {
		wrapper.getPosition().moveWest(wrapper.getSpeed());
	}

}
