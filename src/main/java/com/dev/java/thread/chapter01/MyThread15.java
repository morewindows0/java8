package com.dev.java.thread.chapter01;

/**
 * @author: dengxin.chen
 * @date: 2018/11/8 17:51
 * @description:yield()方法，注意yield方法并不会释放锁
 */
public class MyThread15 extends Thread {
    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        int count = 0;
        for (int i = 0; i < 5000000; i++) {
            Thread.yield();
            count = count + (i + 1);
        }
        System.out.println("耗时：" + (System.currentTimeMillis() - beginTime) + "ms");
    }

    public static void main(String[] args) {
        MyThread15 thread = new MyThread15();
        thread.start();
    }
}
