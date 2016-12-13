package autodriveKata;

import org.junit.Test;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CarAheadSpeedSensorShould {

    @Test
    public void xxx() {
        ListBus bus = new ListBus();

        Sensor carAheadSensor = mock(Sensor.class);
        when(carAheadSensor.publish()).thenReturn(() -> "2", () -> "4");

        Sensor plateSensor = mock(Sensor.class);
        when(plateSensor.publish()).thenReturn(() -> "asd123", () -> "asd123");

        Sensor speedSensor = mock(Sensor.class);
        when(speedSensor.publish()).thenReturn(() -> "50", () -> "50");

        Stream.of(carAheadSensor, plateSensor, speedSensor)
                .forEach(sensor -> bus.send(sensor.publish()));

        CarAheadSpeedSensor carAheadSpeedSensor = carAheadSpeedSensor();
        bus.subscribe(carAheadSpeedSensor);
        Message message = carAheadSpeedSensor.publish();
        bus.send(message);

        //verify(carAheadSpeedSensor).receive();

        // Vr = (4 - 2) / 1
        // V = 50 + 2 = 52
        assertThat(message.get(), is("52"));
    }

    private CarAheadSpeedSensor carAheadSpeedSensor() {
        return new CarAheadSpeedSensor() {
            @Override
            public Message publish() {
                return () -> "";
            }

            @Override
            public void receive(Message message) {

            }
        };
    }

}
