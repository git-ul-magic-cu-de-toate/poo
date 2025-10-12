package assignments;

public class GradableAssignment implements Assignment {
    @Override
    public void edit() {
        System.out.println("You can't edit this");
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
