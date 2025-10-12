package assignments;

public class EditableAssignment implements Assignment {
    @Override
    public void edit() {
        System.out.println("Editing...");
    }

    @Override
    public void grade() {
        System.out.println("Grading...");
    }

    @Override
    public void view() {
        System.out.println("Viewing...");
    }
}
