import factories.FactoryMethodStudent;
import users.User;

public class FactoryMethodMain {
  public static void main(String[] args) {
    FactoryMethodStudent studentFactory = new FactoryMethodStudent();
    User student = studentFactory.createUser("student");

    System.out.println(student.getRights());
  }
}
