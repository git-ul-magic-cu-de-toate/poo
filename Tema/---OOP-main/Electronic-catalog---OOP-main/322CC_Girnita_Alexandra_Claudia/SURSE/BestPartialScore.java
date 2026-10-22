import java.util.ArrayList;

public class BestPartialScore implements BestScoreStrategy {
    public Student getBestStudent(Course course) {
        ArrayList<Grade> grades = course.getGrades();
        double bestPartialScore = -1;
        Student bestPartialScoreStudent = null;

        for (Grade grade : grades) {
            if (grade.getPartialScore() > bestPartialScore) {
                bestPartialScore = grade.getPartialScore();
                bestPartialScoreStudent = grade.getStudent();
            }
        }

        return bestPartialScoreStudent;
    }
}
