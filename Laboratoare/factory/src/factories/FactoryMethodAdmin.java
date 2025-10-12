package factories;

import users.Admin;
import users.User;

public class FactoryMethodAdmin implements FactoryMethodUser {
    @Override
    public User createUser(String type) {
        return new Admin();
    }
}
