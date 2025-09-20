package org.pranish.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueProducerConsumer {
    public static void main(String[] args) {
        BlockingQueue<Integer> q =  new ArrayBlockingQueue<>(10);

        Runnable producer = () -> {
            for (int i = 0; i <10; i++) {
                try {
                    q.put(i);
                    System.out.println("Produces-"+i+" size -"+q.size());
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Runnable consumer = () -> {
            while (true) {
                Integer val;
                try {
                    val = q.take();
                    System.out.println("Consumes-"+val+" size -"+q.size());
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread pro = new Thread(producer);
        Thread con = new Thread(consumer);

        pro.start();
        con.start();
    }
}
