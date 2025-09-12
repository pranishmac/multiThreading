package org.pranish.basicMultithreading;

public class ExtendThread {
    public static void main(String[] args) {
        Thread t1 = new Thread1();
        Thread t2 = new Thread2();
        t1.start();
        t2.start();
    }
}

class Thread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("t1: "+i);
        }
    }
}

class Thread2 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("t2: "+i);
        }
    }
}