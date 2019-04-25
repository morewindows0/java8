package com.dev.java.thread.chapter01;

/**
 * @author: dengxin.chen
 * @date: 2018/11/8 11:46
 * @description:线程中不同享数据情况
 */
public class MyThread05 extends Thread {
    private int count = 5;

    public MyThread05(String name) {
        this.setName(name);
    }

    @Override
    public void run() {
        while (count > 0) {
            count--;
            System.out.println("由" + this.currentThread().getName() + "计算，count=" + count);
        }
    }

    public static void main(String[] args) {
        MyThread05 thread01 = new MyThread05("A");
        MyThread05 thread02 = new MyThread05("B");
        MyThread05 thread03 = new MyThread05("C");
        thread01.start();
        thread02.start();
        thread03.start();
    }
}
