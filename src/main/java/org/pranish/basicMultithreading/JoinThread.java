package org.pranish.basicMultithreading;

public class JoinThread {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println("t1 - "+i);
            }
        });

        Thread t2 = new Thread(()->{
            for (int i = 0; i < 6; i++) {
                System.out.println("t2 - "+i);
            }
        });

        System.out.println("Before execution");
        t1.start();
        t2.start();
        t1.join(100);
        t2.join();
        System.out.println("After execution");
    }
}
