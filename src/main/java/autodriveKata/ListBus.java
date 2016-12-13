package autodriveKata;

import java.util.ArrayList;
import java.util.List;

public class ListBus implements Bus {

    private List<Subscriber> subscribers;

    public ListBus() {
        subscribers = new ArrayList<>();
    }

    @Override
    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void send(Message message) {
        subscribers.forEach(s -> s.receive(message));
    }
}
