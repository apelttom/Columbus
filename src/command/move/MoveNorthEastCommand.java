package command.move;

import command.wrapper.MovePositionCommandWrapper;

public class MoveNorthEastCommand  extends MoveCommand {

	public MoveNorthEastCommand(MovePositionCommandWrapper wrapper) {
		super(wrapper);
	}

	@Override
	public void execute() {
		wrapper.getPosition().moveNorthEast(wrapper.getSpeed());
	}

}
