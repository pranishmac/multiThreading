package org.pranish.executorServiceDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPool {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);

        executor.schedule(()->{
            System.out.println("Print after 3 seconds");
        }, 3, TimeUnit.SECONDS);

        executor.scheduleAtFixedRate(() -> {
            System.out.println("FixedRate every 3s: " + Thread.currentThread().getName());
        }, 1, 3, TimeUnit.SECONDS);

        // Fixed delay
        executor.scheduleWithFixedDelay(() -> {
            System.out.println("FixedDelay every 3s after previous ends: " + Thread.currentThread().getName());
            try { Thread.sleep(2000); } catch (InterruptedException ignored) {}
        }, 1, 3, TimeUnit.SECONDS);

//        executor.shutdown();

    }
}
