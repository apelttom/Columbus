package command;

import core.Position;

public class CommandWrapper {

	private Position position;
	
	public CommandWrapper(Position position){
		this.position = position;
	}
	
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	
}
