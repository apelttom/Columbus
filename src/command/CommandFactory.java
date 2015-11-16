package command;

import model.Direction;

public class CommandFactory {
	
	public <T> Command getCommand(Direction.Course course, T wrapper){
		switch (course) {
		case NORTH:
			if(wrapper instanceof MovePositionCommandWrapper){
				return new MoveNorthCommand((MovePositionCommandWrapper) wrapper);
			}else if (wrapper instanceof ChangeFacingCommandWrapper) {
				return new ChangeFacingNorthCommand((ChangeFacingCommandWrapper)wrapper);
			}
			break;/*
		case NORTHEAST:
			doNorthEastAction(action);
			break;
		case EAST:
			doEastAction(action);
			break;
		case SOUTHEAST:
			doSouthEastAction(action);
			break;
		case SOUTH:
			doSouthAction(action);
			break;
		case SOUTHWEST:
			doSouthWestAction(action);
			break;
		case WEST:
			doWestAction(action);
			break;
		case NORTHWEST:
			doNorthWestAction(action);
			break;
		default:
			doDefaultAction(action);
			return false;
		}*/
		}
		return null;
	}

}
