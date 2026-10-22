public class Assistant extends User implements Comparable<Assistant> {
    public Assistant(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public int compareTo(Assistant assistant) {
        if (this.getFirstName().compareTo(assistant.getFirstName()) == 0) {
            return this.getLastName().compareTo(assistant.getLastName());
        }
        return this.getFirstName().compareTo(assistant.getFirstName());
    }
}
