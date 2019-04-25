package com.dev.java.thread.chapter01;

import java.util.Random;

/**
 * @author: dengxin.chen
 * @date: 2018/11/9 9:56
 * @description: 线程优先级
 */
public class MyThread16 extends Thread {
    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            Random random = new Random();
            random.nextInt();
        }
        long endTime = System.currentTimeMillis();

        System.out.println("★★★★★ thread 1 use time=" + (endTime - beginTime));
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            MyThread16 thread16 = new MyThread16();
            thread16.setPriority(5);
            thread16.start();
            MyThread17 thread17 = new MyThread17();
            thread17.setPriority(6);
            thread17.start();
        }
    }
}

class MyThread17 extends Thread {
    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            Random random = new Random();
            random.nextInt();
        }
        long endTime = System.currentTimeMillis();

        System.out.println(" ☆☆☆☆☆☆thread 2 use time=" + (endTime - beginTime));
    }
}
