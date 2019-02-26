package com.developer.jdk8.thread.chapter04;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: dengxin.chen
 * @date: 2018/11/20 10:48
 * @description:使用condition来实现一对一的生产者和消费者模式
 */
public class ConditionProductorAndConsumer {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean hasValue = false;

    public void set() {
        try {
            lock.lock();
            while (hasValue == true) {
                System.out.println("有可能★★连续");
                condition.await();
            }
            System.out.println("生产★");
            hasValue = true;
            condition.signalAll();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void get() {
        try {
            lock.lock();
            while (hasValue == false) {
                System.out.println("有可能☆☆连续出现");
                condition.await();
            }
            System.out.println("消费☆");
            hasValue = false;
            condition.signalAll();

        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        ConditionProductorAndConsumer pc = new ConditionProductorAndConsumer();
        for (int i = 0; i < 10; i++) {
            Thread p = new Thread(() -> {
                while (true) {
                    pc.set();
                }
            });
            Thread c = new Thread(() -> {
                while (true) {
                    pc.get();
                }
            });
            p.start();
            c.start();
        }

    }

}
