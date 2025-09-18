package org.pranish.executorServiceDemo;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExec {
    public static void main(String[] args) {
        //wrapping Exec service inside try implements auto closable, no need to write t1.shutdown(); this works after Java 21.
        try(ExecutorService t1 = Executors.newFixedThreadPool(3)) {
            for (int i = 0; i < 7; i++) {
                int taskId = i;
                t1.submit(() -> {
                    System.out.println("Task - " + taskId + " running on " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Task - " + taskId + " completed by " + Thread.currentThread().getName());
                    throw new RuntimeException("Boom!");
                });
            }

        }
    }
}
