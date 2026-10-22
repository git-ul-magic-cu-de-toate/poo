public class Student extends User implements Comparable<Student> {
    private Parent mother = null;
    private Parent father = null;

    public Student(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public void setMother(Parent mother) {
        this.mother = mother;
    }

    public void setFather(Parent father) {
        this.father = father;
    }

    public Parent getMother() {
        return this.mother;
    }

    public Parent getFather() {
        return this.father;
    }

    @Override
    public int compareTo(Student student) {
        if (this.getFirstName().compareTo(student.getFirstName()) == 0) {
            return this.getLastName().compareTo(student.getLastName());
        }
        return this.getFirstName().compareTo(student.getFirstName());
    }
}
