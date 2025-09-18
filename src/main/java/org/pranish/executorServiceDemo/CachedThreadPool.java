package org.pranish.executorServiceDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {
    public static void main(String[] args) {
        try(ExecutorService executor = Executors.newCachedThreadPool()){
            for (int i = 0; i < 500; i++) {
                executor.execute(new Tasks(i));
            }
        }
    }
}

class Tasks implements Runnable {
    private final int taskId;

    public  Tasks(int taskId){
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("Task: "+taskId+ " is run by "+ Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Task: "+taskId+ " is completed by "+ Thread.currentThread().getName());

    }
}
