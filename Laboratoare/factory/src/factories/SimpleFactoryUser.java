package factories;

import users.Admin;
import users.Student;
import users.Teacher;
import users.User;

public interface SimpleFactoryUser {
    static User createUser(String type) {
        return switch (type) {
            case "student" -> new Student();
            case "teacher" -> new Teacher();
            case "admin" -> new Admin();
            default -> null;
        };
    }
}
