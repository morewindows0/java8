package com.developer.jdk8.thread.chapter03.waittest;

/**
 * @author: dengxin.chen
 * @date: 2018/11/16 15:30
 * @description:
 */
public class WaitThreadA extends Thread {

    private Object lock;

    public WaitThreadA(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                System.out.println("开始 wait time=" + System.currentTimeMillis());
                lock.wait(); //会释放锁
                System.out.println("结束 end time=" + System.currentTimeMillis());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Object lock = new Object();
        WaitThreadA threadA = new WaitThreadA(lock);
        threadA.start();
        Thread.sleep(3000);
        WaitThreadB threadB = new WaitThreadB(lock);
        threadB.start();

    }
}

class WaitThreadB extends Thread {

    private Object lock;

    public WaitThreadB(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            System.out.println("开始 notify 时间=" + System.currentTimeMillis());
            lock.notify();
            System.out.println("结束 notify 时间=" + System.currentTimeMillis());
        }
    }
}
