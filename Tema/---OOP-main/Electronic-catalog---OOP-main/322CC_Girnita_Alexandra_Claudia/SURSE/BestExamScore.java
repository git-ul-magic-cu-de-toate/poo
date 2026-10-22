import java.util.ArrayList;

public class BestExamScore implements BestScoreStrategy {
    public Student getBestStudent(Course course) {
        ArrayList<Grade> grades = course.getGrades();
        double bestExamScore = -1;
        Student bestExamScoreStudent = null;

        for (Grade grade : grades) {
            if (grade.getExamScore() > bestExamScore) {
                bestExamScore = grade.getExamScore();
                bestExamScoreStudent = grade.getStudent();
            }
        }

        return bestExamScoreStudent;
    }
}
