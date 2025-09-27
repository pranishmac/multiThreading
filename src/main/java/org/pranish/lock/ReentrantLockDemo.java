package org.pranish.lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    public static void main(String[] args) {
        SharedClass share = new SharedClass();

//        share.access();

        Thread t1 = new Thread(()->{
            share.access();
        });
        Thread t2 = new Thread(()->{
            share.access();
        });
        t1.start();
        t2.start();
    }
}

class SharedClass{
    private final ReentrantLock lock = new ReentrantLock();

    public void access(){
        lock.lock();
        System.out.println("Lock acquired by "+ Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            System.out.println("Lock released by "+ Thread.currentThread().getName());
            lock.unlock();
        }
    }
}
