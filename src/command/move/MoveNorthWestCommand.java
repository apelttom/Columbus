package command.move;

import command.wrapper.MovePositionCommandWrapper;

public class MoveNorthWestCommand extends MoveCommand {

	public MoveNorthWestCommand(MovePositionCommandWrapper wrapper) {
		super(wrapper);
	}

	@Override
	public void execute() {
		wrapper.getPosition().moveNorthWest(wrapper.getSpeed());
	}

}
