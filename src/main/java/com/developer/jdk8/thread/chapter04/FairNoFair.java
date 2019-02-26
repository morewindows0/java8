package com.developer.jdk8.thread.chapter04;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: dengxin.chen
 * @date: 2018/11/20 11:08
 * @description:Lock的公平锁和非公平锁
 */
public class FairNoFair {

    private Lock lock;

    public FairNoFair(boolean isFair) {
        this.lock = new ReentrantLock(isFair);
    }

    public void serviceMethod() {
        try {
            lock.lock();
            System.out.println("Threadname=" + Thread.currentThread().getName() + "获得锁定");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

//        FairNoFair fairNoFair = new FairNoFair(true);
        FairNoFair fairNoFair = new FairNoFair(false); //非公平锁

        Runnable runnable = () -> {
            System.out.println("☆线程" + Thread.currentThread().getName() + "运行了");
            fairNoFair.serviceMethod();
        };

        Thread[] threadArray = new Thread[10];

        for (int i = 0; i < 10; i++) {
            threadArray[i] = new Thread(runnable);
        }
        for (int i = 0; i < 10; i++) {
            threadArray[i].start();
        }

    }
}
