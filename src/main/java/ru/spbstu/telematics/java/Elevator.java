package ru.spbstu.telematics.java;

import java.util.concurrent.Semaphore;

class Elevator
{
    private int currentPassengerCount;
    private Semaphore elevatorSemaphore;

    public Elevator()
    {
        this.currentPassengerCount = 0;
        this.elevatorSemaphore = new Semaphore(1);
    }

    public int getCurrentPassengerCount() { return currentPassengerCount; }

    public void enter() throws InterruptedException
    {
        elevatorSemaphore.acquire();
        try
        {
            if (currentPassengerCount < 10)
            {
                currentPassengerCount++;
                System.out.println("Passenger entered Elevator. Current count: " + currentPassengerCount);
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
            if (currentPassengerCount > 0)
            {
                currentPassengerCount--;
                System.out.println("Passenger exited Elevator. Current count: " + currentPassengerCount);
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