package assignments;

public class ViewOnlyAssignment implements Assignment {
    @Override
    public void edit() {
        System.out.println("You can't edit this");
    }

    @Override
    public void grade() {
        System.out.println("You can't grade this");
    }

    @Override
    public void view() {
        System.out.println("Viewing...");
    }
}
