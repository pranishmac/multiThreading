package org.pranish.locking;

public class WaitNotifyDemo {
    private static final Object lock = new Object();
    public static void main(String[] args) {
        Thread t1 =  new Thread(()->{
            try {
                execute1();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2 =  new Thread(()->{
            try {
                execute2();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t1.start();
        t2.start();
    }

    public static void execute1() throws InterruptedException {
        System.out.println("In exec1 for t1");
        synchronized (lock){
            System.out.println("before lock t1");
            lock.wait();
            System.out.println("after lock t1");
        }
    }

    public static void execute2() throws InterruptedException {
        System.out.println("In exec2 for t2");
        synchronized (lock){
            System.out.println("before lock t2");
            lock.notify();
            System.out.println("after lock t2");
        }
    }

}
