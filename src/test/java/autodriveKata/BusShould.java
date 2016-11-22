package autodriveKata;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class BusShould {

    private Bus bus;

    @Before
    public void setUp() throws Exception {
        bus = new Bus() {
            private Subscriber subscriber;

            @Override
            public void subscribe(Subscriber subscriber) {
                this.subscriber = subscriber;
            }

            @Override
            public void send(Message message) {
                subscriber.receive(message);
            }
        };
    }

    @Test
    public void send_a_message_to_a_subscriber() {
        Subscriber subscriber = mock(Subscriber.class);
        bus.subscribe(subscriber);
        Message message = new Message() { };
        bus.send(message);

        verify(subscriber, times(1)).receive(any());
    }

}
