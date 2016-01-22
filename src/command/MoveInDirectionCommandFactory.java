package command;

import command.move.MoveEastCommand;
import command.move.MoveNorthCommand;
import command.move.MoveNorthEastCommand;
import command.move.MoveNorthWestCommand;
import command.move.MoveSouthCommand;
import command.move.MoveSouthEastCommand;
import command.move.MoveSouthWestCommand;
import command.move.MoveWestCommand;
import command.wrapper.DirectionMoveParameterWrapper;
import model.Direction;

/**
 * TODO: Change command factory name to MoveCommand Factory
 * 
 * @author tapeltauer
 *
 */
public class MoveInDirectionCommandFactory extends CommandFactory {

	public <T> Command createCommand(T parameterWrapper) {
		if (parameterWrapper instanceof DirectionMoveParameterWrapper) {
			DirectionMoveParameterWrapper directionParameterWrapper = (DirectionMoveParameterWrapper) parameterWrapper;
			Direction.Course course = directionParameterWrapper.getCourse();
			switch (course) {
			case NORTH:
				return new MoveNorthCommand(directionParameterWrapper);
			case NORTHEAST:
				return new MoveNorthEastCommand(directionParameterWrapper);
			case EAST:
				return new MoveEastCommand(directionParameterWrapper);
			case SOUTHEAST:
				return new MoveSouthEastCommand(directionParameterWrapper);
			case SOUTH:
				return new MoveSouthCommand(directionParameterWrapper);
			case SOUTHWEST:
				return new MoveSouthWestCommand(directionParameterWrapper);
			case WEST:
				return new MoveWestCommand(directionParameterWrapper);
			case NORTHWEST:
				return new MoveNorthWestCommand(directionParameterWrapper);
			default:
				return null;
			}
		}
		return null;
	}

}
