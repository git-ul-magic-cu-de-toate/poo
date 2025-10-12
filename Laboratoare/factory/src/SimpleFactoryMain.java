import factories.SimpleFactoryUser;
import users.User;

import java.util.stream.Stream;

public class SimpleFactoryMain {
    public static void main(String[] args) {
        Stream.of("student", "teacher", "admin")
                .map(SimpleFactoryUser::createUser)
                .map(User::getRights)
                .forEach(System.out::println);
    }
}
