import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Map;

public class StudentPage extends JFrame {
    private JLabel content;
    private Catalog catalog;
    private Student student;

    public String getStudentPageContent() {
        String result = "";
        result += "======== " + student.getFirstName() + " " + student.getLastName() + " ========\n";
        int firstLineLength = result.length() - 1;

        // lista cursuri la care este inscris studentul
        result += "Lista cursuri la care e inscris studentul:\n";
        for (Course course : catalog.courses) {
            ArrayList<Student> students = course.getAllStudents();

            for (Student s : students) {
                if (student.compareTo(s) == 0) {
                    result += "  Nume curs: " + course.getName() + "\n";

                    result += "  Profesor titular: " + course.getTeacher().getFirstName() + " " + course.getTeacher().getLastName() + "\n";

                    result += "  Lista asistenti: ";
                    for (Assistant assistant : course.getAssistants()) {
                        result += assistant.getFirstName() + " " + assistant.getLastName() + "; ";
                    }
                    result += "\n";

                    result += "  Asistentul asociat studentul: ";
                    for (Map.Entry<String, Group> entry : course.getGroups().entrySet()) {
                        for (Student s2 : entry.getValue()) {
                            if (student.compareTo(s2) == 0) {
                                result += entry.getValue().getAssistant().getFirstName() + " " + entry.getValue().getAssistant().getLastName();
                            }
                            break;
                        }
                    }
                    result += "\n";

                    result += "  Notele pe care le-a primit studentul: ";
                    for (Grade grade : course.getGrades()) {
                        if (student.compareTo(grade.getStudent()) == 0) {
                            result += grade.getTotal() + "; ";
                        }
                    }
                    result += "\n";

                    break;
                }
            }
            result += "\n\n";
        }

        for (int i = 0; i < firstLineLength; i++) {
            result += "=";
        }
        result += "\n";

        return result;
    }

    public StudentPage(Catalog catalog, Student student) {
        super("Student Page");
        this.catalog = catalog;
        this.student = student;

        setMinimumSize(new Dimension(400, 400));
        getContentPane().setBackground (Color.pink);
        setLayout(new FlowLayout());

        JPanel jPanel = new JPanel();
        jPanel.setBounds(61, 11, 81, 140);
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
        this.add(jPanel);

        content = new JLabel("<html>" + getStudentPageContent().replace("\n", "<br/>") + "</html>");
        jPanel.add(content);

        this.show();
        this.pack();
    }
}
