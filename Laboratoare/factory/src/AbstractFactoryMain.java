import assignments.Assignment;
import factories.NoRightsAbstractFactory;
import users.User;

public class AbstractFactoryMain {
    public static void main(String[] args) {
        NoRightsAbstractFactory factory = new NoRightsAbstractFactory();
        User student = factory.createUser();
        Assignment assignment = factory.createAssignment();

        System.out.println(student.getRights());
        assignment.view();
    }
}
