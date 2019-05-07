package com.dev.java.thread.chapter04;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: dengxin.chen
 * @date: 2018/11/19 18:02
 * @description:
 */
public class MyService {
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void waitMethod() {
        try {
            lock.lock();
            System.out.println("A");
            condition.await();
            System.out.println("B");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println("锁被释放了");
        }
    }

    public void sigal() {
        try {
            lock.lock();
            System.out.println("signal时间为：" + System.currentTimeMillis());
            condition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) throws InterruptedException {

        MyService myService = new MyService();

        Thread thread = new Thread(() -> myService.waitMethod());
        thread.start();
        Thread.sleep(3000);
        myService.sigal();

    }
}
