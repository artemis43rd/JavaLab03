package ru.spbstu.telematics.java;

import java.util.Random;

class Passenger extends Thread {
    private Elevator elevator;
    private String name;

    public Passenger(Elevator elevator, String name) {
        this.elevator = elevator;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(500));
            System.out.println(name + " wants to enter the elevator.");
            elevator.enter();

            Thread.sleep(new Random().nextInt(500));
            System.out.println(name + " is inside the elevator.");

            elevator.exit();
            System.out.println(name + " exited the elevator.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
