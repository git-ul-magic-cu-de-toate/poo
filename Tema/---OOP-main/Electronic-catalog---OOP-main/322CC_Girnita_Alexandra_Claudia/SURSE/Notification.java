public class Notification {
    private Grade grade;

    Notification(Grade grade) {
        this.grade = grade;
    }

    public Grade getGrade() {
        return this.grade;
    }

    @Override
    public String toString() {
        return "Studentul " + grade.getStudent().getFirstName() + " a obtinut nota: " + grade.getTotal();
    }
}
