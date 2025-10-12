import java.util.LinkedList;

public class Invoker {
    private final LinkedList<Command> commands = new LinkedList<>();
    private final LinkedList<Command> redoCommands = new LinkedList<>();

    public void execute(Command command) {
        commands.push(command);
        command.execute();
        redoCommands.clear();
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
