package command.wrapper;

import units.UnitPosition;

public class CommandWrapper {

	private UnitPosition position;
	
	public CommandWrapper(UnitPosition position){
		this.position = position;
	}
	
	public UnitPosition getPosition() {
		return position;
	}
	public void setPosition(UnitPosition position) {
		this.position = position;
	}
	
}
