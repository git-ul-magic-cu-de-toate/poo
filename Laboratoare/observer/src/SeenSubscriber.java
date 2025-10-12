public class SeenSubscriber implements Subscriber {
    @Override
    public void update(String title) {
        System.out.println("Seen " + title);
    }
}
