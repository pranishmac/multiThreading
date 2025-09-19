package org.pranish.executorServiceDemo;

import java.util.concurrent.CountDownLatch;

public class LatchDemo {
    public static void main(String[] args) throws InterruptedException {
        int workers = 3;
        CountDownLatch latch = new CountDownLatch(workers);

        for (int i = 0; i < workers; i++) {
            int count = i;
            Thread t1 = new Thread(()->{
                System.out.println("Worker-"+ count +"started");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Worker-"+ count +"finished");
                latch.countDown();
            });
            t1.start();
        }

        System.out.println("Worker about to start");
        latch.await();
        System.out.println("All workers finished");

    }
}
