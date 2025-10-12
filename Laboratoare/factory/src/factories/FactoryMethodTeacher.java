package factories;

import users.Teacher;
import users.User;

public class FactoryMethodTeacher implements FactoryMethodUser {
    @Override
    public User createUser(String type) {
        return new Teacher();
    }
}
