package ru.spbstu.telematics.java;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

class Elevator
{
    private AtomicInteger currentPassengerCount;
    private Semaphore elevatorSemaphore;

    public Elevator()
    {
        this.currentPassengerCount = new AtomicInteger(0);
        this.elevatorSemaphore = new Semaphore(1);
    }

    public int getCurrentPassengerCount()
    {
        return currentPassengerCount.get();
    }

    public void enter() throws InterruptedException
    {
        elevatorSemaphore.acquire();
        try
        {
            if (currentPassengerCount.get() < 10)
            {
                currentPassengerCount.incrementAndGet();
                System.out.println("Passenger entered Elevator. Current count: " + currentPassengerCount.get());
            }
            else
                System.out.println("Elevator is full. Passenger cannot enter.");
        }
        finally
        {
            elevatorSemaphore.release();
        }
    }

    public void exit() throws InterruptedException
    {
        elevatorSemaphore.acquire();
        try
        {
            if (currentPassengerCount.get() > 0)
            {
                currentPassengerCount.decrementAndGet();
                System.out.println("Passenger exited Elevator. Current count: " + currentPassengerCount.get());
            }
            else
                System.out.println("No passengers inside Elevator. Cannot exit.");
        }
        finally 
        {
            elevatorSemaphore.release();
        }
    }
}