public class Text {
    private StringBuilder value = new StringBuilder();

    public void add(char newCharacter) {
        value.append(newCharacter);
    }

    public void delete(int index) {
        value.deleteCharAt(index);
    }

    public void setValue(String value) {
        this.value = new StringBuilder(value);
    }

    public String getValue() {
        return value.toString();
    }
}
