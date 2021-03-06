package command.facing;

import command.Command;
import command.wrapper.ChangeFacingCommandWrapper;
import model.Direction;

public class ChangeFacingNorthCommand implements Command {

	private ChangeFacingCommandWrapper wrapper;
	
	public ChangeFacingNorthCommand(ChangeFacingCommandWrapper wrapper) {
		this.wrapper = wrapper;
	}

	@Override
	public void execute() {
		wrapper.getPosition().setFacing(Direction.Course.NORTH);
	}

}
