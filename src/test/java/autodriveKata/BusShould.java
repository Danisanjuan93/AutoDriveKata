package autodriveKata;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class BusShould {

    private Bus bus;

    @Before
    public void setUp() throws Exception {
        bus = new ListBus();
    }

    @Test
    public void send_a_message_to_a_subscriber() {
        Subscriber subscriber = mock(Subscriber.class);
        bus.subscribe(subscriber);
        Message message = new Message() { };
        bus.send(message);

        verify(subscriber, times(1)).receive(any());
    }

    @Test
    public void send_a_message_to_all_subscribers() {
        Subscriber subscriber1 = mock(Subscriber.class);
        Subscriber subscriber2 = mock(Subscriber.class);
        Subscriber subscriber3 = mock(Subscriber.class);
        bus.subscribe(subscriber1);
        bus.subscribe(subscriber2);
        bus.subscribe(subscriber3);
        Message message = new Message() { };
        bus.send(message);

        verify(subscriber1, times(1)).receive(any());
        verify(subscriber2, times(1)).receive(any());
        verify(subscriber3, times(1)).receive(any());
    }

}
