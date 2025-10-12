package factories;

import assignments.Assignment;
import assignments.GradableAssignment;
import users.Teacher;
import users.User;

public class SomeRightsAbstractFactory implements RightsAbstractFactory {
    @Override
    public User createUser() {
        return new Teacher();
    }

    @Override
    public Assignment createAssignment() {
        return new GradableAssignment();
    }
}
