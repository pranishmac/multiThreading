package org.pranish.basicMultithreading;

public class ThreadOne implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i <10; i++) {
            System.out.println("t1: "+i);
        }
    }
}
