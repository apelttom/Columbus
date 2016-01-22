package command;

public abstract class CommandFactory {
	
	protected abstract <T> Command createCommand(T parameterWrapper);

}
