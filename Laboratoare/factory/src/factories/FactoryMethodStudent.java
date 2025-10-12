package factories;

import users.Student;
import users.User;

public class FactoryMethodStudent implements FactoryMethodUser {
    @Override
    public User createUser(String type) {
        return new Student();
    }
}
