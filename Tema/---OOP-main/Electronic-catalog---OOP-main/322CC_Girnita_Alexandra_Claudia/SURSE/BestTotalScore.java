import java.util.ArrayList;

public class BestTotalScore implements BestScoreStrategy {
    public Student getBestStudent(Course course) {
        ArrayList<Grade> grades = course.getGrades();
        double bestTotalScore = -1;
        Student bestTotalScoreStudent = null;

        for (Grade grade : grades) {
            if (grade.getTotal() > bestTotalScore) {
                bestTotalScore = grade.getTotal();
                bestTotalScoreStudent = grade.getStudent();
            }
        }

        return bestTotalScoreStudent;
    }
}
