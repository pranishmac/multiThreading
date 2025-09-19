package org.pranish.executorServiceDemo;

import java.util.concurrent.*;

public class CallableDemo {
    public static void main(String[] args) {
        try(ExecutorService executor = Executors.newFixedThreadPool(3)){
            Future<?> retVal = executor.submit(new Task());

            System.out.println(retVal.get());
            System.out.println("Main T completed");
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


class Task implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return 100;
    }
}