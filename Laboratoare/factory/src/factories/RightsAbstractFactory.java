package factories;

import assignments.Assignment;
import users.User;

public interface RightsAbstractFactory {
    User createUser();
    Assignment createAssignment();
}
