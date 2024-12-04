
import java.util.HashMap;
import java.util.Map;

class NewsAgency {
    private Map<String, Subscriber> subscribers = new HashMap<>();

    public void addSubscriber(Subscriber subscriber) {
        if (subscriber instanceof NewsSubscriber) {
            String name = ((NewsSubscriber) subscriber).getName();
            subscribers.put(name, subscriber);
            Logger.getInstance().log("Subscriber added: " + subscriber);
        }
    }

    public void removeSubscriber(String name) {
        if (subscribers.remove(name) != null) {
            Logger.getInstance().log("Subscriber removed: " + name);
        }
        else {
            Logger.getInstance().log("no matching subscriber found: " + name);
        }
    }

    public void notifySubscribers(String news) {
        for (Subscriber subscriber : subscribers.values()) {
            subscriber.update(news);
        }
    }
    public Map<String, Subscriber> getSubscribers() {
        return subscribers;
    }
}