import com.sun.source.tree.Tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        Catalog catalog = Catalog.getCatalog();
        UserFactory uf = new UserFactory();

        // citire studenti din fisier
        File studentsFile = new File("students_basic.txt");
        Scanner studentsScanner = new Scanner(studentsFile);
        int numberOfStudents = Integer.parseInt(studentsScanner.nextLine());
        Student[] students = new Student[numberOfStudents];

        for (int i = 0; i < numberOfStudents; i++) {
            String firstName, lastName;
            firstName = studentsScanner.nextLine();
            lastName = studentsScanner.nextLine();
            students[i] = (Student) uf.createUser("Student", firstName, lastName);
        }
        studentsScanner.close();

        // citire parinti din fisier
        File parentsFile = new File("parents_basic.txt");
        Scanner parentsScanner = new Scanner(parentsFile);
        int numberOfParents = Integer.parseInt(parentsScanner.nextLine());
        Parent[] parents = new Parent[numberOfParents];

        for (int i = 0; i < numberOfParents; i++) {
            String firstName, lastName;
            firstName = parentsScanner.nextLine();
            lastName = parentsScanner.nextLine();
            parents[i] = (Parent) uf.createUser("Parent", firstName, lastName);
        }
        parentsScanner.close();

        // citire cursuri din fisier
        File coursesFile = new File("courses_basic.txt");
        Scanner coursesScanner = new Scanner(coursesFile);
        int numberOfCourses = Integer.parseInt(coursesScanner.nextLine());
        Course[] courses = new Course[numberOfCourses];

        for (int i = 0; i < numberOfCourses; i++) {
            PartialCourse course = new PartialCourse();
            String courseTitle = coursesScanner.nextLine();
            course.getPartialCourseBuilder().buildName(courseTitle);

            String teacherFullName = coursesScanner.nextLine();
            Teacher teacher = (Teacher) uf.createUser("Teacher", teacherFullName.split(" ")[0], teacherFullName.split(" ")[1]);
            course.setTeacher(teacher);

            int numberOfGroups = Integer.parseInt(coursesScanner.nextLine());
            for (int j = 0; j < numberOfGroups; j++) {
                String groupId = coursesScanner.nextLine();
                String assistantFullName = coursesScanner.nextLine();

                Assistant assistant = new Assistant(assistantFullName.split(" ")[0], assistantFullName.split(" ")[1]);
                Group group = new Group(groupId, assistant);
                course.addGroup(group);
                course.addAssistant(groupId, assistant);
            }
            courses[i] = course;
        }
        coursesScanner.close();

        // testare observer
        System.out.println("===== TESTARE OBSERVER ========");
        Student s1 = students[0];
        Student s2 = students[1];
        Parent p1 = parents[0];
        Parent p2 = parents[1];
        s1.setMother(p1);
        s2.setMother(p2);
        Grade g = new Grade(1.6, 5, s1, "ED");
        Grade g2 = new Grade(0.8, 2, s2, "AA");

        catalog.addObserver(p1);
        catalog.addObserver(p2);
        catalog.notifyObservers(g);
        catalog.notifyObservers(g2);

        // testare strategy
        System.out.println("===== TESTARE STRATEGY ========");
        PartialCourse partialCourse = (PartialCourse) courses[0];
        partialCourse.setBestScoreStrategy(new BestPartialScore());
        partialCourse.addStudent("grupa1", s1);
        partialCourse.addStudent("grupa1", s2);
        partialCourse.addGrade(g);
        partialCourse.addGrade(g2);
        System.out.println("Numele celui mai bun student la partial " + partialCourse.getBestStudent().getFirstName());

        catalog.addCourse(partialCourse);

        // testare visitor
        System.out.println("===== TESTARE VISITOR ========");
        ScoreVisitor scoreVisitor = new ScoreVisitor();
        ScoreVisitor scoreVisitor2 = new ScoreVisitor();
        partialCourse.accept(scoreVisitor, new Grade(2, 3.4, s1, "POO"));
        partialCourse.accept(scoreVisitor2, new Grade(1.4, 2, s2, "MN"));

        // testare memento
        System.out.println("===== TESTARE MEMENTO ========");
        System.out.println("Before memento:");
        for (Grade grade : partialCourse.getGrades()) {
            System.out.println(grade.getStudent().getFirstName() + ", nota: " + grade.getTotal());
        }
        System.out.printf("Making a copy of the current grades");
        partialCourse.makeBackup();
        System.out.println("Adding a new grade:");
        partialCourse.addGrade(new Grade(3.75, 2.5, s1, "POO"));
        partialCourse.addGrade(new Grade(4.1, 1.65, s2, "PP"));
        for (Grade grade : partialCourse.getGrades()) {
            System.out.println(grade.getStudent().getFirstName() + ", nota: " + grade.getTotal());
        }
        System.out.println("Undo to the previous state:");
        partialCourse.undo();
        for (Grade grade : partialCourse.getGrades()) {
            System.out.println(grade.getStudent().getFirstName() + ", nota: " + grade.getTotal());
        }

        // instantiere Student Page
        StudentPage studentPage = new StudentPage(catalog, s1);
        StudentPage studentPage2 = new StudentPage(catalog, s2);

        // instantiere Teacher / Assistant Page
        TeacherAssistantPage teacherAssistantPage = new TeacherAssistantPage(catalog, partialCourse.getTeacher(), scoreVisitor);
        Assistant assistant = null;
        for (Map.Entry<String, Group> entry : partialCourse.getGroups().entrySet()) {
            if (entry.getKey().compareTo("grupa1") == 0) {
                assistant = entry.getValue().getAssistant();
            }

        }
        TeacherAssistantPage teacherAssistantPage2 = new TeacherAssistantPage(catalog, assistant, scoreVisitor);

        // instantiere Parent Page
        ParentPage parentPage = new ParentPage(p1);
        ParentPage parentPage2 = new ParentPage(p2);
    }
}