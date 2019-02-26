package com.developer.jdk8.thread.chapter03.waittest;

/**
 * @author: dengxin.chen
 * @date: 2018/11/16 17:48
 * @description:过早通知，会导致通知失效
 */
public class NotifyThreadTest {

    private Object lock = new Object();

    public Runnable runnableA = () -> {
        try {
            synchronized (lock) {
                System.out.println("begin wait");
                lock.wait();
                System.out.println("begin end");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    };

    public Runnable runnableB = () -> {
        synchronized (lock) {
            System.out.println("begin notify");
            lock.notify();
            System.out.println("end notify");
        }
    };

    public static void main(String[] args) {
        NotifyThreadTest run = new NotifyThreadTest();
        Thread b = new Thread(run.runnableB);
        b.start();
        Thread a = new Thread(run.runnableA);
        a.start();


    }
}
