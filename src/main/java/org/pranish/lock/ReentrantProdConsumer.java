package org.pranish.lock;

import java.util.concurrent.locks.*;

class BoundedBuffer {
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition notFull  = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    private final int[] buffer = new int[5];
    private int count = 0, putIndex = 0, takeIndex = 0;

    public void put(int value) throws InterruptedException {
        lock.lock();
        try {
            while (count == buffer.length) {
                notFull.await();  // wait if buffer full
            }
            buffer[putIndex] = value;
            putIndex = (putIndex + 1) % buffer.length;
            count++;
            notEmpty.signal();  // signal consumer
        } finally {
            lock.unlock();
        }
    }

    public int take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                notEmpty.await(); // wait if buffer empty
            }
            int val = buffer[takeIndex];
            takeIndex = (takeIndex + 1) % buffer.length;
            count--;
            notFull.signal(); // signal producer
            return val;
        } finally {
            lock.unlock();
        }
    }
}

class ReentrantProdConsumer {
    public static void main(String[] args) {
        BoundedBuffer bufferObj = new BoundedBuffer();
        Runnable prod = ()->{
            try{
                bufferObj.put(10);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        };
        Runnable cons = ()->{
            try{
                bufferObj.take();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        };
        Thread t1 = new Thread(prod);
        Thread t2 = new Thread(cons);
        t1.start();
        t2.start();

    }
}
