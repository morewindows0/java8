package com.dev.java.thread.chapter01;

/**
 * @author: dengxin.chen
 * @date: 2018/11/8 11:30
 * @description:执行start的顺序并不代表线程启动的顺序
 */
public class MyThread03 extends Thread {

    private int i;

    public MyThread03(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println(i);
    }

    public static void main(String[] args) {
        MyThread03 thread01 = new MyThread03(1);
        MyThread03 thread02 = new MyThread03(2);
        MyThread03 thread03 = new MyThread03(3);
        MyThread03 thread04 = new MyThread03(4);
        MyThread03 thread05 = new MyThread03(5);
        MyThread03 thread06 = new MyThread03(6);
        MyThread03 thread07 = new MyThread03(7);
        thread01.start();
        thread02.start();
        thread03.start();
        thread04.start();
        thread05.start();
        thread06.start();
        thread07.start();

        /**
         * 执行结果
         *
         1
         3
         5
         7
         4
         6
         2
         */
    }
}
