package autodriveKata;

public interface Bus {
    void subscribe(Subscriber subscriber);

    void send(Message message);
}
