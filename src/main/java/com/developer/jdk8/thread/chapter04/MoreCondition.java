package com.developer.jdk8.thread.chapter04;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: dengxin.chen
 * @date: 2018/11/20 10:39
 * @description:多condition进行指定唤醒
 */
public class MoreCondition {
    private Lock lock = new ReentrantLock();
    public Condition conditionA = lock.newCondition();
    public Condition conditionB = lock.newCondition();

    public void awaitA() {
        try {
            lock.lock();
            System.out.println("begin awaitA时间为" + System.currentTimeMillis() + " ThreadName=" + Thread.currentThread().getName());
            conditionA.await();
            System.out.println("end awaitA时间为" + System.currentTimeMillis() + " ThreadName=" + Thread.currentThread().getName());
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    public void awaitB() {
        try {
            lock.lock();
            System.out.println("begin awaitB时间为" + System.currentTimeMillis() + " ThreadName=" + Thread.currentThread().getName());
            conditionB.await();
            System.out.println("end awaitB时间为" + System.currentTimeMillis() + " ThreadName=" + Thread.currentThread().getName());
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    public void signalAll_A() {
        try {
            lock.lock();
            System.out.println("signalAll_A时间为" + System.currentTimeMillis() + " ThreadName=" + Thread.currentThread().getName());
            conditionA.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void signalAll_B() {
        try {
            lock.lock();
            System.out.println("signalAll_B时间为" + System.currentTimeMillis() + " ThreadName=" + Thread.currentThread().getName());
            conditionB.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        MoreCondition moreCondition = new MoreCondition();

        Thread thread = new Thread(() -> moreCondition.awaitA(), "A");
        thread.start();
        Thread threadB = new Thread(() -> moreCondition.awaitB(), "B");
        threadB.start();

        Thread.sleep(3000);
        moreCondition.signalAll_B();//可指定唤醒线程

    }
}
