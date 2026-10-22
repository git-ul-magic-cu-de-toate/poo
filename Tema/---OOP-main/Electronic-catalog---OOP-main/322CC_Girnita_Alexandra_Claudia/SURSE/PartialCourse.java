import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class PartialCourse extends Course {
    private PartialCourseBuilder partialCourseBuilder;

    public PartialCourseBuilder getPartialCourseBuilder() {
        return this.partialCourseBuilder;
    }

    PartialCourse() {
        this.partialCourseBuilder = new PartialCourseBuilder();
    }

    protected class PartialCourseBuilder extends Course.CourseBuilder {
        public void buildName(String name) {
            PartialCourse.this.setName(name);
        }
        public void buildTeacher(Teacher teacher) {
            PartialCourse.this.setTeacher(teacher);
        }
        public void buildAssistants(HashSet<Assistant> assistants) {
            PartialCourse.this.setAssistants(assistants);
        }
        public void buildGrades(ArrayList<Grade> grades) {
            PartialCourse.this.setGrades(grades);
        }
        public void buildGroups(HashMap<String, Group> groups) {
            PartialCourse.this.setGroups(groups);
        }
        public void buildCredits(int credits) {
            PartialCourse.this.setCredits(credits);
        }
    }

    public ArrayList<Student> getGraduatedStudents() {
        ArrayList<Student> students = new ArrayList<>();

        HashMap<Student, Grade> studentGrades = getAllStudentGrades();

        for (Map.Entry<Student, Grade> entry : studentGrades.entrySet()) {
            if (entry.getValue().getTotal() >= 5) {
                students.add(entry.getKey());
            }
        }

        return students;
    }
}
