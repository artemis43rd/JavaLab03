package ru.spbstu.telematics.java;

import org.junit.Test;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

public class ElevatorTest
{
    @Test
    public void testElevator() throws InterruptedException
    {
        Elevator elevator = new Elevator();

        for (int i = 1; i < 30; i++)
        {
            Passenger passenger = new Passenger(elevator, "Passenger " + i);
            passenger.start();
        }

        TimeUnit.SECONDS.sleep(2);
        assertEquals(0, elevator.getCurrentPassengerCount());
    }
}