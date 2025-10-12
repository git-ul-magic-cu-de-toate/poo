public class File {
    private String text;

    public File(String text) {
        this.text = text;
    }

    public void append(String newText) {
        this.text += newText;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
