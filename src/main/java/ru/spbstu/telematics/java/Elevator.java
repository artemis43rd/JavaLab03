package ru.spbstu.telematics.java;

import java.util.concurrent.Semaphore;

class Elevator {
    private int currentPassengerCount;
    private Semaphore elevatorSemaphore;
    private int elevatorNumber; // Новая переменная для номера лифта

    public Elevator(int elevatorNumber) {
        this.currentPassengerCount = 0;
        this.elevatorSemaphore = new Semaphore(1);
        this.elevatorNumber = elevatorNumber;
    }

    public int getCurrentPassengerCount() {
        return currentPassengerCount;
    }

    public int getElevatorNumber() {
        return elevatorNumber;
    }

    public void enter() throws InterruptedException {
        elevatorSemaphore.acquire();
        if (currentPassengerCount < 10) {
            currentPassengerCount++;
            System.out.println("Passenger entered Elevator " + elevatorNumber + ". Current count: " + currentPassengerCount);
        } else {
            System.out.println("Elevator " + elevatorNumber + " is full. Passenger cannot enter.");
        }
        elevatorSemaphore.release();
    }

    public void exit() throws InterruptedException {
        elevatorSemaphore.acquire();
        if (currentPassengerCount > 0) {
            currentPassengerCount--;
            System.out.println("Passenger exited Elevator " + elevatorNumber + ". Current count: " + currentPassengerCount);
        } else {
            System.out.println("No passengers inside Elevator " + elevatorNumber + ". Cannot exit.");
        }
        elevatorSemaphore.release();
    }
}