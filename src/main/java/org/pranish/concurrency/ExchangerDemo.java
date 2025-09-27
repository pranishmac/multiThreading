package org.pranish.concurrency;

import java.util.concurrent.Exchanger;

public class ExchangerDemo {
    public static void main(String[] args) {
        Exchanger<String> ex = new Exchanger<>();

        new Thread(()->{
            String message = "Thread 1 data";
            System.out.println("T1 sending - "+ message);
            try {
                String reply = ex.exchange(message);
                System.out.println("T1 receives - "+ reply);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(()->{
            String message = "Thread 2 data";
            System.out.println("T2 sending - "+ message);
            try {
                String reply = ex.exchange(message);
                System.out.println("T2 receives - "+ reply);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
