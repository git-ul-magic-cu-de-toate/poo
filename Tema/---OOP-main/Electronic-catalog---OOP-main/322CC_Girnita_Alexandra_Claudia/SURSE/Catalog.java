import java.util.ArrayList;

public class Catalog implements Subject {
    private static Catalog catalog = null;
    public ArrayList<Course> courses = new ArrayList<>();
    private ArrayList<Observer> subscribedParents = new ArrayList<>();

    private Catalog() {

    }

    public static Catalog getCatalog() {
        if (catalog == null) {
            catalog = new Catalog();
        }
        return catalog;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    // watch out for this one
    public void removeCourse(Course course) {
        courses.remove(course);
    }

    public ArrayList<Observer> getSubscribedParents() {
        return subscribedParents;
    }

    // Observer pattern
    public void addObserver(Observer observer) {
        this.subscribedParents.add(observer);
    }
    public void removeObserver(Observer observer) {
        for (Observer parent : subscribedParents) {
            if (((Parent) parent).isSameParent((Parent) observer)) {
                subscribedParents.remove(parent);
                break;
            }
        }
    }
    public void notifyObservers(Grade grade) {
        for (Observer parent : subscribedParents) {
            if (((Parent) parent).isSameParent(grade.getStudent().getMother()) ||
                    ((Parent) parent).isSameParent(grade.getStudent().getMother())) {
                parent.update(new Notification(grade));
            }
        }
    }
}
