public class Grade implements Comparable<Grade>, Cloneable {
    private Double partialScore, examScore;
    private Student student;
    private String course;

    public Grade(
            double partialScore, double examScore,
            Student student, String course
            ) {
        this.partialScore = partialScore;
        this.examScore = examScore;
        this.student = student;
        this.course = course;
    }

    public void setPartialScore(double partialScore) {
        this.partialScore = partialScore;
    }

    public void setExamScore(double examScore) {
        this.examScore = examScore;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Double getPartialScore() {
        return this.partialScore;
    }

    public Double getExamScore() {
        return this.examScore;
    }

    public Student getStudent() {
        return this.student;
    }

    public String getCourse() {
        return this.course;
    }

    public double getTotal() {
        return this.partialScore + this.examScore;
    }

    @Override
    public int compareTo(Grade grade) {
        double myTotal = this.getTotal();
        double theirTotal = grade.getTotal();

        if (myTotal < theirTotal) {
            return -1;
        } else if (myTotal > theirTotal) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Student studentCopy = new Student(this.student.getFirstName(), this.student.getLastName());
        Grade newGrade = new Grade(this.partialScore, this.examScore, studentCopy, this.course);
        return newGrade;
    }
}
