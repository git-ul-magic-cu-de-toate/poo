package factories;

import users.User;

interface FactoryMethodUser {
    User createUser(String type);
}
