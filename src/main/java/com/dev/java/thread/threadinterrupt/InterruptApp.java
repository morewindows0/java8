package com.dev.java.thread.threadinterrupt;

/**
 * @author: developer
 * @date: 2019/2/16 21:24
 * @description: 中断测试主程序
 */

public class InterruptApp {


    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 500000; i++) {
                System.out.println("i=" + (i + 1));
            }
            System.out.println("我是t1线程");
        });
        t1.start();
        Thread.sleep(200);
        t1.interrupt();
        Thread.currentThread().interrupt();
        System.out.println("isInterrupted()=" + t1.isInterrupted());
        System.out.println("isInterrupted()=" + t1.isInterrupted());
        System.out.println("interrupted()=" + t1.interrupted());
        System.out.println("interrupted()=" + Thread.interrupted());
    }

    /*
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 500000; i++) {
                System.out.println("i=" + (i + 1));
            }
            System.out.println("我是t1线程");
        });
        t1.start();
        Thread.sleep(200);
        t1.interrupt();
        System.out.println("isInterrupted()=" + t1.isInterrupted());
        System.out.println("isInterrupted()=" + t1.isInterrupted());
        System.out.println("interrupted()=" + t1.interrupted());
        System.out.println("interrupted()=" + Thread.interrupted());
    }
    */

    /*
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 500000; i++) {
                if (Thread.currentThread().isInterrupted()) {  // 对中断进行处理
                    System.out.println("t1线程被中断了");
                    return;
                }
                System.out.println("i=" + (i + 1));
            }
            System.out.println("我是t1线程");
        });
        t1.start();
        Thread.sleep(200);
        t1.interrupt();
    }
    */


  /*
  public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 500000; i++) {
                System.out.println("i=" + (i + 1));
            }
            System.out.println("我是t1线程");
        });
        t1.start();
        Thread.sleep(200);
        t1.interrupt();  // 仅仅对线程打一个中断标记
    }
  */

}
