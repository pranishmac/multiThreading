package org.pranish.locking;

import org.w3c.dom.css.CSSPageRule;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {
    private static final int CAPACITY = 5;
    private static Queue<Integer> q = new LinkedList<>();

    public void produce() throws InterruptedException {
        int val = 0;
        while (true) {
            synchronized (q) {
                while (q.size() == CAPACITY) {
                    System.out.println("Capacity full producer is waiting...");
                    q.wait();
                }
                System.out.println(val + "added to buffer..size - "+q.size());
                q.add(val++);
                q.notifyAll();
            }
            Thread.sleep(2000);
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (q) {
                while (q.size() == 0) {
                    System.out.println("Buffer empty consumer waiting");
                    q.wait();
                }
                int con = q.poll();
                System.out.println(con + "is consumed.. size - " + q.size());
                q.notifyAll();
            }
            Thread.sleep(8000);
        }
    }

    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer();
        Thread producer = new Thread(() -> {
            try {
                pc.produce();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread consumer = new Thread(() -> {
            try {
                pc.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        producer.start();
        consumer.start();
    }
}
