package org.pranish.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        int runners = 3;
        CyclicBarrier barrier = new CyclicBarrier(runners,()->{
            System.out.println("All runners reached barrier");
        });

        Runnable run = () ->{
            String name = Thread.currentThread().getName();
            System.out.println("Runner" + name +" warming up!");
            try {
                Thread.sleep((long)Math.random() * 1000);
                System.out.println(name + " is ready to run");
                barrier.await();
                System.out.println("Running started by "+name);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        };

        ExecutorService ex = Executors.newFixedThreadPool(runners);

        for (int i = 0; i < runners; i++) {
            ex.execute(run);
        }

        ex.shutdown();
    }
}
