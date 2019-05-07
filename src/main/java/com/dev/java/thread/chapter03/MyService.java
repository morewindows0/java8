package com.dev.java.thread.chapter03;

/**
 * @author: dengxin.chen
 * @date: 2018/11/16 17:10
 * @description: 演示线程被wait后，调用interrupt会抛出异常
 */
public class MyService {

    public void testMethod(Object lock) {
        try {
            synchronized (lock) {
                System.out.println("begin wait");
                lock.wait();
                System.out.println("end wait");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("出现异常了，因为呈现wait状态的线程被interrupt了");
        }
    }
}

class TestThread extends Thread {

    private Object lock;

    public TestThread(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        MyService service = new MyService();
        service.testMethod(lock);
    }

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        TestThread thread = new TestThread(lock);
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
        NotifyThread notifyThread=new NotifyThread(lock);
        notifyThread.start();
    }
}

class NotifyThread extends Thread {

    private Object lock;

    public NotifyThread(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            lock.notify();
        }
    }
}
