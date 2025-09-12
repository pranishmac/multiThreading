package org.pranish.basicMultithreading;

public class RunnableThread {
    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadOne());
        Thread t2 = new Thread(new ThreadTwo());
        Thread t3 = new Thread(()->{
            System.out.println("Lambda method");
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
