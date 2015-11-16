package command;

public class MoveNorthCommand implements Command{
	
	private MovePositionCommandWrapper wrapper;

	public MoveNorthCommand(MovePositionCommandWrapper wrapper) {
		this.wrapper = wrapper;
	}
	
	@Override
	public void execute() {
		wrapper.getPosition().moveNorth(wrapper.getSpeed());	
	}

}
