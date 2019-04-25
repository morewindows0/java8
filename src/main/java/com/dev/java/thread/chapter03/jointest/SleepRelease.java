package com.dev.java.thread.chapter03.jointest;

/**
 * @author: dengxin.chen
 * @date: 2018/11/19 16:29
 * @description: sleep不释放锁
 */
public class SleepRelease extends Thread {
    private ThreadA threadA;

    public SleepRelease(ThreadA threadA) {
        this.threadA = threadA;
    }

    @Override
    public void run() {
        try {
            synchronized (threadA) {
                threadA.start();
//                Thread.sleep(6000);
                threadA.join();
                for (int i = 0; i < 8000; i++) {
                    Math.random();
                }
                System.out.println("A 线程执行完后，才执行该段代码");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class ThreadA extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("A run begin time=" + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("A run end time=" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void aService() {
        System.out.println("打印 aService time=" + System.currentTimeMillis());
    }
}

class ThreadB extends Thread {
    private ThreadA threadA;

    public ThreadB(ThreadA threadA) {
        this.threadA = threadA;
    }

    @Override
    public void run() {
        threadA.aService();
    }
}

class TestRun {

    public static void main(String[] args) throws InterruptedException {
        ThreadA threadA = new ThreadA();
        SleepRelease sleepRelease = new SleepRelease(threadA);
        sleepRelease.start();
        Thread.sleep(1000);
        ThreadB threadB = new ThreadB(threadA);
        threadB.start();
    }
}

