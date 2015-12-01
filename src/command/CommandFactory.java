package command;

import command.facing.ChangeFacingNorthCommand;
import command.move.MoveEastCommand;
import command.move.MoveNorthCommand;
import command.move.MoveNorthEastCommand;
import command.move.MoveNorthWestCommand;
import command.move.MoveSouthCommand;
import command.move.MoveSouthEastCommand;
import command.move.MoveSouthWestCommand;
import command.move.MoveWestCommand;
import command.wrapper.ChangeFacingCommandWrapper;
import command.wrapper.MovePositionCommandWrapper;
import model.Direction;

/**
 * TODO: Change command factory name to MoveCommand Factory
 * @author tapeltauer
 *
 */
public class CommandFactory {
	
	public <T> Command getCommand(Direction.Course course, T wrapper){
		switch (course) {
		case NORTH:
			if(wrapper instanceof MovePositionCommandWrapper){
				return new MoveNorthCommand((MovePositionCommandWrapper) wrapper);
			}else if (wrapper instanceof ChangeFacingCommandWrapper) {
				return new ChangeFacingNorthCommand((ChangeFacingCommandWrapper)wrapper);
			}
			break;
		case NORTHEAST:
			if(wrapper instanceof MovePositionCommandWrapper){
				return new MoveNorthEastCommand((MovePositionCommandWrapper) wrapper);
			}else if (wrapper instanceof ChangeFacingCommandWrapper) {
//				TODO: write proper facing commands
//				return new ChangeFacingNorthEastCommand((ChangeFacingCommandWrapper)wrapper);
			}
			break;
		case EAST:
			if(wrapper instanceof MovePositionCommandWrapper){
				return new MoveEastCommand((MovePositionCommandWrapper) wrapper);
			}else if (wrapper instanceof ChangeFacingCommandWrapper) {
//				TODO: write proper facing commands
//				return new ChangeFacingNorthEastCommand((ChangeFacingCommandWrapper)wrapper);
			}
			break;
		case SOUTHEAST:
			if(wrapper instanceof MovePositionCommandWrapper){
				return new MoveSouthEastCommand((MovePositionCommandWrapper) wrapper);
			}else if (wrapper instanceof ChangeFacingCommandWrapper) {
//				TODO: write proper facing commands
//				return new ChangeFacingNorthEastCommand((ChangeFacingCommandWrapper)wrapper);
			}
			break;
		case SOUTH:
			if(wrapper instanceof MovePositionCommandWrapper){
				return new MoveSouthCommand((MovePositionCommandWrapper) wrapper);
			}else if (wrapper instanceof ChangeFacingCommandWrapper) {
//				TODO: write proper facing commands
//				return new ChangeFacingNorthEastCommand((ChangeFacingCommandWrapper)wrapper);
			}
			break;
		case SOUTHWEST:
			if(wrapper instanceof MovePositionCommandWrapper){
				return new MoveSouthWestCommand((MovePositionCommandWrapper) wrapper);
			}else if (wrapper instanceof ChangeFacingCommandWrapper) {
//				TODO: write proper facing commands
//				return new ChangeFacingNorthEastCommand((ChangeFacingCommandWrapper)wrapper);
			}
			break;
		case WEST:
			if(wrapper instanceof MovePositionCommandWrapper){
				return new MoveWestCommand((MovePositionCommandWrapper) wrapper);
			}else if (wrapper instanceof ChangeFacingCommandWrapper) {
//				TODO: write proper facing commands
//				return new ChangeFacingNorthEastCommand((ChangeFacingCommandWrapper)wrapper);
			}
			break;
		case NORTHWEST:
			if(wrapper instanceof MovePositionCommandWrapper){
				return new MoveNorthWestCommand((MovePositionCommandWrapper) wrapper);
			}else if (wrapper instanceof ChangeFacingCommandWrapper) {
//				TODO: write proper facing commands
//				return new ChangeFacingNorthEastCommand((ChangeFacingCommandWrapper)wrapper);
			}
			break;/*
		default:
			doDefaultAction(action);
			return false;
		}*/
		}
		return null;
	}

}
