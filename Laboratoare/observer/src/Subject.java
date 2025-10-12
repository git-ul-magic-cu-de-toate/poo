public interface Subject {
    void addSubscriber(Subscriber subscriber);
    void setTitle(String title);
    String getTitle();
}
