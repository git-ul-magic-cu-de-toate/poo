public class AppendCommand implements Command {
    private File file;
    private String newText;
    private String prevText;

    public AppendCommand(File file, String newText) {
        this.file = file;
        this.newText = newText;
    }

    @Override
    public void execute() {
        prevText = file.getText();
        file.append(newText);
    }

    @Override
    public void undo() {
        String newPrevText = file.getText();
        file.setText(prevText);
        prevText = newPrevText;
    }
}
