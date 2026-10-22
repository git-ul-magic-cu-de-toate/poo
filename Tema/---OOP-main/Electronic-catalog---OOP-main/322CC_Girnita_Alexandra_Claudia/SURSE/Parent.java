import java.util.ArrayList;

public class Parent extends User implements Observer {
    private ArrayList<Grade> childGrades = new ArrayList<>();
    public Parent(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public ArrayList<Grade> getChildGrades() {
        return this.childGrades;
    }

    public boolean isSameParent(Parent parent) {
        return this.getLastName().compareTo(parent.getLastName()) == 0
                && this.getFirstName().compareTo(parent.getFirstName()) == 0;
    }

    public void update(Notification notification) {
        childGrades.add(notification.getGrade());
        System.out.println(notification);
    }
}
