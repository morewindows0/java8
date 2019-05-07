package com.dev.java.thread.chapter01;

/**
 * @author: dengxin.chen
 * @date: 2018/11/8 13:59
 * @description:同享数据的情况，通过synchronized关键字来实现数据同步
 */
public class MyThread06 extends Thread {
    private int count = 5;

    @Override
    public synchronized void run() {
        count--;
        System.out.println("由" + this.currentThread().getName() + "计算，count=" + count);
    }


    public static void main(String[] args) {
        MyThread06 myThread06 = new MyThread06();

        Thread thread01 = new Thread(myThread06, "A");
        Thread thread02 = new Thread(myThread06, "B");
        Thread thread03 = new Thread(myThread06, "C");
        Thread thread04 = new Thread(myThread06, "D");
        Thread thread05 = new Thread(myThread06, "E");

        thread01.start();
        thread02.start();
        thread03.start();
        thread04.start();
        thread05.start();
    }
}
