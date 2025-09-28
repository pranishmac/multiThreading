package org.pranish.lock;
import java.util.concurrent.Semaphore;

public class SemaphoreLocks {
    public static void main(String[] args) {
        // Only 2 permits → at most 2 threads can work at the same time
        Semaphore semaphore = new Semaphore(2);

        Runnable task = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " waiting for permit...");
                semaphore.acquire(); // take permit
                System.out.println(Thread.currentThread().getName() + " got permit, working...");
                Thread.sleep(2000); // simulate work
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + " releasing permit...");
                semaphore.release(); // return permit
            }
        };

        // Start 5 threads, but only 2 can run at a time
        for (int i = 0; i < 5; i++) {
            new Thread(task, "Thread-" + i).start();
        }
    }
}
