/**
 * Subject - blog
 * Subscriber
 */

public class Main {
    public static void main(String[] args) {
        Blog blog = new Blog();
        blog.addSubscriber(new SeenSubscriber());

        blog.setTitle("New?");
    }
}
