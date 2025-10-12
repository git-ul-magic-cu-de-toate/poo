public class DeleteLastCharacter extends Command {
    public DeleteLastCharacter(Text text) {
        super(text);
    }

    @Override
    public void execute() {
        previousValue = text.getValue();
        text.delete(text.getValue().length() - 1);
    }
}
