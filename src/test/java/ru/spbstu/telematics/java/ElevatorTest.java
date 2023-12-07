package ru.spbstu.telematics.java;

import org.junit.Test;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;


public class ElevatorTest {

    @Test
    public void testElevator() throws InterruptedException {
        Elevator elevator = new Elevator(1);

        for (int i = 1; i < 100; i++) {
            Passenger passenger = new Passenger(elevator, "Passenger " + i);
            passenger.start();
        }

        // Ждем завершения всех потоков
        TimeUnit.SECONDS.sleep(3);

        // Проверяем, что текущее количество пассажиров в лифте равно 0
        assertEquals(0, elevator.getCurrentPassengerCount());
    }
}