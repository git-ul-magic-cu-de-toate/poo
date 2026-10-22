//import com.sun.source.tree.Tree;
//
//import javax.swing.*;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.*;
//
//public class Test {
//    public static void main(String[] args) throws FileNotFoundException {
//        Catalog catalog = Catalog.getCatalog();
//        UserFactory uf = new UserFactory();
//
//        // citire fisier curs+grupa+asistent+student+parinti
//        File studentsFile = new File("students.txt");
//        Scanner studentsScanner = new Scanner(studentsFile);
//        for (int j = 0; j < 2; j++)
//        {
//            String nume_cursuri = studentsScanner.nextLine();
//            String[] linia = nume_cursuri.split("\\s+");
//            String nume_curs1 = linia[0];
//            String nume_curs2 = linia[1];
//            Assistant a1, a2;
//            String firstName1, lastName1, firstName2, lastName2;
//            String grupa1_curs, grupa2_curs;
//            String grupe_curs1 = studentsScanner.nextLine();
//            String asis = studentsScanner.nextLine();
//            String[] linia_mea = asis.split("\\s+");
//            firstName1 = linia_mea[0]; //asistent1
//            lastName1 = linia_mea[1];
//            firstName2 = linia_mea[2]; //asistent2 de la celalalt curs al grupei
//            lastName2 = linia_mea[3];
//            a1 = new Assistant(firstName1, lastName1);
//            a2 = new Assistant(firstName2, lastName2);
//            Group grupa_unu = new Group(grupe_curs1,a1);
//            Group grupa_doi = new Group(grupe_curs1,a2);
//            for (int i = 0; i < 5; i++) {
//                Student my_stud = null;
//                String grupe_curs1;
//                String familie; //copil + parinti
//                familie = studentsScanner.nextLine();
//                String[] linie = familie.split("\\s+");
//                if (linie.length == 6)
//                {
//                    my_stud = new Student(linie[0], linie[1]);
//                    my_stud.setMother(new Parent(linie[2], linie[3]));
//                    my_stud.setFather(new Parent(linie[4],linie[5]));
//                }
//                if (linie.length == 2)
//                {
//                    my_stud = new Student(linie[0], linie[1]);
//                    my_stud.setMother(null);
//                    my_stud.setFather(null);
//                }
//                if (linie.length == 4)
//                {
//                    my_stud = new Student(linie[0], linie[1]);
//                    if (linie[3].charAt(linie[3].length()-1)=='a')
//                    {
//                        my_stud.setMother(new Parent(linie[2], linie[3]));
//                    }
//                    else {
//                        my_stud.setFather(new Parent(linie[2], linie[3]));
//                    }
//                }
//                grupa_unu.add(my_stud);
//                grupa_doi.add(my_stud);
//            }
//            // acum e pentru a doua grupa
//            String grupe_curs2 = studentsScanner.nextLine();
//            String asis = studentsScanner.nextLine();
//            String[] linia_mea = asis.split("\\s+");
//            firstName1 = linia_mea[0]; //asistent1
//            lastName1 = linia_mea[1];
//            firstName2 = linia_mea[2]; //asistent2 de la celalalt curs al grupei
//            lastName2 = linia_mea[3];
//            a1 = new Assistant(firstName1, lastName1);
//            a2 = new Assistant(firstName2, lastName2);
//            Group grupa_trei = new Group(grupe_curs1,a1);
//            Group grupa_patru = new Group(grupe_curs1,a2);
//            for (int i = 0; i < 5; i++) {
//                Student my_stud = null;
//                String grupe_curs1;
//                String familie; //copil + parinti
//                familie = studentsScanner.nextLine();
//                String[] linie = familie.split("\\s+");
//                if (linie.length == 6)
//                {
//                    my_stud = new Student(linie[0], linie[1]);
//                    my_stud.setMother(new Parent(linie[2], linie[3]));
//                    my_stud.setFather(new Parent(linie[4],linie[5]));
//                }
//                if (linie.length == 2)
//                {
//                    my_stud = new Student(linie[0], linie[1]);
//                    my_stud.setMother(null);
//                    my_stud.setFather(null);
//                }
//                if (linie.length == 4)
//                {
//                    my_stud = new Student(linie[0], linie[1]);
//                    if (linie[3].charAt(linie[3].length()-1)=='a')
//                    {
//                        my_stud.setMother(new Parent(linie[2], linie[3]));
//                    }
//                    else {
//                        my_stud.setFather(new Parent(linie[2], linie[3]));
//                    }
//                }
//                grupa_trei.add(my_stud);
//                grupa_patru.add(my_stud);
//            }
//            ArrayList<Group> cursul1 = new ArrayList<>();
//            ArrayList<Group> cursul2 = new ArrayList<>();
//            cursul1.add(grupa_unu);
//            cursul1.add(grupa_trei);
//            cursul2.add(grupa_doi);
//            cursul2.add(grupa_patru);
//            cursuri_cu_grupe.put(nume_curs1, cursul1);
//            cursuri_cu_grupe.put(nume_curs2, cursul2);
//        }
//        studentsScanner.close();
//
//        // citire cursuri din fisier
//        File coursesFile = new File("courses.txt");
//        Scanner coursesScanner = new Scanner(coursesFile);
//
//        for (int i = 0; i < 4; i++) {
//            FullCourse course_full = new FullCourse();
//            PartialCourse course_partial = new PartialCourse();
//
//            String courseTitle = coursesScanner.nextLine();
//            if(courseTitle == "POO" || courseTitle == "PP" || courseTitle == "SO")
//            {
//                course_full.getFullCourseBuilder().buildName(courseTitle);
//            }
//            else {
//                course_partial.getPartialCourseBuilder().buildName(courseTitle);
//            }
//            if(courseTitle == "POO" || courseTitle == "SO")
//                course_full.setBestScoreStrategy(new BestPartialScore());
//            if(courseTitle == "PP")
//                course_full.setBestScoreStrategy(new BestExamScore());
//            if(courseTitle == "ED")
//                course_partial.setBestScoreStrategy(new BestTotalScore());
//            String teacherFullName = coursesScanner.nextLine();
//            Teacher teacher = (Teacher) uf.createUser("Teacher", teacherFullName.split(" ")[0], teacherFullName.split(" ")[1]);
//            course_partial.setTeacher(teacher);
//        }
//        coursesScanner.close();
//
//        //citire note studenti
//        File scoreFile = new File("exam_scores.txt");
//        Scanner scoreScanner = new Scanner(scoreFile);
//        for (int j = 0; j < 4; j++)
//        {
//            String nume_curs = scoreScanner.nextLine();
//            for (int i = 0; i < 12; i++) {
//                String firstName, lastName;
//                firstName = scoreScanner.nextLine();
//                lastName = scoreScanner.nextLine();
//            }
//        }
//        scoreScanner.close();
//
//        // testare strategy
//        System.out.println("======== TESTARE STRATEGY ========");
//        PartialCourse partialCourse = (PartialCourse) courses[0];
//        partialCourse.setBestScoreStrategy(new BestPartialScore());
//        partialCourse.addStudent("grupa1", s1);
//        partialCourse.addStudent("grupa1", s2);
//        partialCourse.addGrade(g);
//        partialCourse.addGrade(g2);
//        System.out.println("numele celui mai bun elev cu nota la partial " + partialCourse.getBestStudent().getFirstName());
//        catalog.addCourse(partialCourse);
//
//        // testare visitor
//        System.out.println("======== TESTARE VISITOR ========");
//        ScoreVisitor scoreVisitor = new ScoreVisitor();
//        partialCourse.accept(scoreVisitor, new Grade(3.5, 2, s1, "curs de curs"));
//
//        // testare memento
//        System.out.println("======== TESTARE MEMENTO ========");
//        System.out.println("Before memento:");
//        for (Grade grade : partialCourse.getGrades()) {
//            System.out.println(grade.getStudent().getFirstName() + ", nota: " + grade.getTotal());
//        }
//        System.out.printf("Making a copy of the current grades");
//        partialCourse.makeBackup();
//        System.out.println("Adding a new grade:");
//        partialCourse.addGrade(new Grade(5, 5, s1, "curs de curs"));
//        for (Grade grade : partialCourse.getGrades()) {
//            System.out.println(grade.getStudent().getFirstName() + ", nota: " + grade.getTotal());
//        }
//        System.out.println("Undo to the previous state:");
//        partialCourse.undo();
//        for (Grade grade : partialCourse.getGrades()) {
//            System.out.println(grade.getStudent().getFirstName() + ", nota: " + grade.getTotal());
//        }
//
//        // instantiere Student Page
//        StudentPage studentPage = new StudentPage(catalog, s1);
//        // instantiere Teacher / Assistant Page
//        TeacherAssistantPage teacherAssistantPage = new TeacherAssistantPage(catalog, partialCourse.getTeacher(), scoreVisitor);
//        Assistant assistant = null;
//        for (Map.Entry<String, Group> entry : partialCourse.getGroups().entrySet()) {
//            if (entry.getKey().compareTo("grupa1") == 0) {
//                assistant = entry.getValue().getAssistant();
//            }
//        }
//        TeacherAssistantPage teacherAssistantPage2 = new TeacherAssistantPage(catalog, assistant, scoreVisitor);
//        // instantiere Parent Page
//        ParentPage parentPage = new ParentPage(p1);
//    }
//}