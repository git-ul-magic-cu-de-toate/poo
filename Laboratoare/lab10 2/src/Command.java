public abstract class Command {
    protected Text text;
    protected String previousValue;

    public Command(Text text) {
        this.text = text;
    }

    public void undo() {
        String newPreviousValue = text.getValue();
        text.setValue(previousValue);
        previousValue = newPreviousValue;
    }

    public abstract void execute();
}
