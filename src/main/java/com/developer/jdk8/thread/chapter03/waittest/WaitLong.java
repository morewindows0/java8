package com.developer.jdk8.thread.chapter03.waittest;

/**
 * @author: dengxin.chen
 * @date: 2018/11/16 17:32
 * @description: wait(long) 超时自动唤醒
 */
public class WaitLong {

    private static Object lock = new Object();

    private static Runnable runnable = new Runnable() {
        @Override
        public void run() {
            try {
                synchronized (lock) {
                    System.out.println("wait begin time=" + System.currentTimeMillis());
                    lock.wait(5000);
                    System.out.println("wait end time=" + System.currentTimeMillis());
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    private static Runnable notifyRunnable = () -> {
        synchronized (lock) {
            System.out.println("notify begin time=" + System.currentTimeMillis());
            lock.notify();
            System.out.println("notify end time=" + System.currentTimeMillis());
        }

    };

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(2000);
        Thread notifyThread = new Thread(notifyRunnable);
        notifyThread.start();
    }
}
