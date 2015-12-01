package command.move;

import command.wrapper.MovePositionCommandWrapper;

public class MoveNorthCommand extends MoveCommand{

	public MoveNorthCommand(MovePositionCommandWrapper wrapper) {
		super(wrapper);
	}
	
	@Override
	public void execute() {
		wrapper.getPosition().moveNorth(wrapper.getSpeed());	
	}

}
