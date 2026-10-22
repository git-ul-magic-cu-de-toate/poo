import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Map;

public class TeacherAssistantPage extends JFrame {
    private JLabel content;
    private Catalog catalog;
    private User teacherOrAssistant;
    private ScoreVisitor scoreVisitor;
    private boolean isTeacher = false;

    public String getTeacherAssistantContent() {
        String result = "======== " + teacherOrAssistant.getFirstName() + " " + teacherOrAssistant.getLastName() + " ========\n";
        int firstLineLength = result.length() - 1;

        // cursuri predate
        result += "Cursuri predate: ";
        for (Course course : catalog.courses) {
            if (isTeacher) {
                if (((Teacher) teacherOrAssistant).compareTo(course.getTeacher()) == 0) {
                    result += course.getName() + "; ";
                }
            } else {
                for (Assistant assistant : course.getAssistants()) {
                    if (((Assistant) teacherOrAssistant).compareTo(assistant) == 0) {
                        result += course.getName() + "; ";
                    }
                }
            }
        }
        result += "\n";

        for (int i = 0; i < firstLineLength; i++) {
            result += "=";
        }
        result += "\n";

        return result;
    }

    public TeacherAssistantPage(Catalog catalog, User teacherOrAssistant, ScoreVisitor scoreVisitor) {
        super("Teacher/Assistant Page");
        this.catalog = catalog;
        this.teacherOrAssistant = teacherOrAssistant;
        this.scoreVisitor = scoreVisitor;

        if (teacherOrAssistant instanceof Teacher) {
            isTeacher = true;
        }

        setMinimumSize(new Dimension(400, 400));
        getContentPane().setBackground (Color.cyan);
        setLayout(new FlowLayout());

        JPanel jPanel = new JPanel();
        jPanel.setBounds(61, 11, 81, 140);
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
        this.add(jPanel);

        content = new JLabel("<html>" + getTeacherAssistantContent().replace("\n", "<br/>") + "</html>");
        jPanel.add(content);

        this.show();
        this.pack();
    }

    public boolean isTeacher() {
        return isTeacher;
    }
}
