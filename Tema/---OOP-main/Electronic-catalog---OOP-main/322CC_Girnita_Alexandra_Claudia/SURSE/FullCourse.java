import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FullCourse extends Course {
    private FullCourseBuilder fullCourseBuilder;

    FullCourse() {
        this.fullCourseBuilder = new FullCourseBuilder();
    }

    public FullCourseBuilder getFullCourseBuilder() {
        return this.fullCourseBuilder;
    }

    protected class FullCourseBuilder extends Course.CourseBuilder {
        public void buildName(String name) {
            FullCourse.this.setName(name);
        }
        public void buildTeacher(Teacher teacher) {
            FullCourse.this.setTeacher(teacher);
        }
        public void buildAssistants(HashSet<Assistant> assistants) {
            FullCourse.this.setAssistants(assistants);
        }
        public void buildGrades(ArrayList<Grade> grades) {
            FullCourse.this.setGrades(grades);
        }
        public void buildGroups(HashMap<String, Group> groups) {
            FullCourse.this.setGroups(groups);
        }
        public void buildCredits(int credits) {
            FullCourse.this.setCredits(credits);
        }
    }

    public ArrayList<Student> getGraduatedStudents() {
        ArrayList<Student> students = new ArrayList<>();

        HashMap<Student, Grade> studentGrades = getAllStudentGrades();
        for (Map.Entry<Student, Grade> entry : studentGrades.entrySet()) {
            if (entry.getValue().getPartialScore() >= 3
            && entry.getValue().getExamScore() >= 2) {
                students.add(entry.getKey());
            }
        }

        return students;
    }
}
