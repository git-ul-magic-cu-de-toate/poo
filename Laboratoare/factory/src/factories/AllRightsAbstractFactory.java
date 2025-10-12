package factories;

import assignments.Assignment;
import assignments.EditableAssignment;
import users.Admin;
import users.User;

public class AllRightsAbstractFactory implements RightsAbstractFactory {
    @Override
    public User createUser() {
        return new Admin();
    }

    @Override
    public Assignment createAssignment() {
        return new EditableAssignment();
    }
}
