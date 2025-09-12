package org.pranish.sequential;

public class SequentialExecution {
    public static void main(String[] args) {
        demo1();
        demo2();
    }

    public static void demo1(){
        for (int i = 0; i < 5; i++) {
            System.out.println("Demo1 : " + i);
        }
    }

    public static void demo2(){
        for (int i = 0; i < 5; i++) {
            System.out.println("Demo 2 : " + i);
        }
    }
}
