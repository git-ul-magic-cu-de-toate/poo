import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Map;

public class ParentPage extends JFrame {
    private JLabel content;
    private Parent parent;

    public String getParentContent() {
        String result = "";
        result += "======== " + "Parent page: " + parent.getFirstName() + " " + parent.getLastName() + " ========\n";
        int firstLineLength = result.length() - 1;

        result += "Notificari cu notele copiilor:\n";
        for (Grade grade : parent.getChildGrades()) {
            result += "Nota copil " + grade.getStudent().getFirstName() + ": " + grade.getTotal() + ", la cursul: " + grade.getCourse() + "\n";
        }

        for (int i = 0; i < firstLineLength; i++) {
            result += "=";
        }
        return result;
    }

    public ParentPage(Parent parent) {
        super("Parent Page");
        this.parent = parent;

        setMinimumSize(new Dimension(400, 400));
        getContentPane().setBackground (Color.red);
        setLayout(new FlowLayout());

        JPanel jPanel = new JPanel();
        jPanel.setBounds(61, 11, 81, 140);
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
        this.add(jPanel);

        content = new JLabel("<html>" + getParentContent().replace("\n", "<br/>") + "</html>");
        jPanel.add(content);

        this.show();
        this.pack();
    }
}
