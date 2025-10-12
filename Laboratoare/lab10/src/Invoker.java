import java.util.LinkedList;

public class Invoker {
    private LinkedList<Command> commands = new LinkedList<>();
    private LinkedList<Command> redoCommands = new LinkedList<>();

    public void execute(Command command) {
        commands.push(command);
        command.execute();
    }

    public void undo() {
        if (commands.isEmpty()) {
            return;
        }
        Command lastCommand = commands.pop();
        lastCommand.undo();
        redoCommands.push(lastCommand);
    }

    public void redo() {
        if (redoCommands.isEmpty()) {
            return;
        }
        Command lastCommand = redoCommands.pop();
        lastCommand.execute();
        commands.push(lastCommand);
    }
}
