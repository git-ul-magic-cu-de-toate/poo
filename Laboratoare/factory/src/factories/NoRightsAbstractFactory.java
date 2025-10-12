package factories;

import assignments.Assignment;
import assignments.ViewOnlyAssignment;
import users.Student;
import users.User;

public class NoRightsAbstractFactory implements RightsAbstractFactory {
    @Override
    public User createUser() {
        return new Student();
    }

    @Override
    public Assignment createAssignment() {
        return new ViewOnlyAssignment();
    }
}
