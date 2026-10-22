public class Teacher extends User implements Comparable<Teacher> {
    public Teacher(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public int compareTo(Teacher teacher) {
        if (this.getFirstName().compareTo(teacher.getFirstName()) == 0) {
            return this.getLastName().compareTo(teacher.getLastName());
        }
        return this.getFirstName().compareTo(teacher.getFirstName());
    }

    public String toString() {
        return "profesor x";
    }
}
