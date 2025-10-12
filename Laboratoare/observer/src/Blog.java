import java.util.ArrayList;
import java.util.List;

public class Blog implements Subject {
    private String title;
    private final List<Subscriber> subscribers = new ArrayList<>();

    @Override
    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
        for (Subscriber subscriber : subscribers) {
            subscriber.update(title);
        }
    }

    @Override
    public String getTitle() {
        return title;
    }
}
