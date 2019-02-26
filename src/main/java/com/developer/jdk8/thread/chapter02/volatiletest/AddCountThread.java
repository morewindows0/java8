package com.developer.jdk8.thread.chapter02.volatiletest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: dengxin.chen
 * @date: 2018/11/16 11:29
 * @description: 演示原子操作
 */
public class AddCountThread extends Thread {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(atomicInteger.incrementAndGet());
        }
    }

    public static void main(String[] args) {

        AddCountThread countThread = new AddCountThread();
        Thread t1 = new Thread(countThread);
        t1.start();
        Thread t2 = new Thread(countThread);
        t2.start();
        Thread t3 = new Thread(countThread);
        t3.start();
        Thread t4 = new Thread(countThread);
        t4.start();

    }
}
