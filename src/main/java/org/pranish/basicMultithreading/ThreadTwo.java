package org.pranish.basicMultithreading;

public class ThreadTwo implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 7; i++) {
            System.out.println("t2: "+i);
        }
    }
}
