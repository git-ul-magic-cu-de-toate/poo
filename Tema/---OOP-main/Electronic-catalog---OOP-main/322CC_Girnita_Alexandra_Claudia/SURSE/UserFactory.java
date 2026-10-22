public class UserFactory {
    public User createUser(String userType, String firstName, String lastName) {
        switch (userType) {
            case "Student":
                return new Student(firstName, lastName);
            case "Parent":
                return new Parent(firstName, lastName);
            case "Assistant":
                return new Assistant(firstName, lastName);
            case "Teacher":
                return new Teacher(firstName, lastName);
            default:
                throw new IllegalArgumentException("Unknown user type");
        }
    }
}
