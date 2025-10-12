public class AddCharacter extends Command {
    private final char newChar;

    public AddCharacter(Text text, char newChar) {
        super(text);
        this.newChar = newChar;
    }

    @Override
    public void execute() {
        previousValue = text.getValue();
        text.add(newChar);
    }
}
