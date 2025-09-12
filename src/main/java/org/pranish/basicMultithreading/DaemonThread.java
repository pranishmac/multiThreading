package org.pranish.basicMultithreading;

public class DaemonThread {
    public static void main(String[] args) {
        Thread t1 = new Thread(new DaemonHelper());
        Thread t2 = new Thread(new UserThread());
        t1.setDaemon(true);

        t1.start();
        t2.start();

    }
}


class DaemonHelper implements Runnable{
    @Override
    public void run() {
        int count = 0;
        while(count<500){
            System.out.println("Daemon is active");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            count++;
        }
    }
}

class UserThread implements Runnable{
    @Override
    public void run() {
        int count = 0;
        while(count<2){
            System.out.println("User is active");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            count++;
        }
    }
}