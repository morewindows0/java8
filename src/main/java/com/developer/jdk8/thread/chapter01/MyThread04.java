package com.developer.jdk8.thread.chapter01;

/**
 * @author: dengxin.chen
 * @date: 2018/11/8 11:34
 * @description:实现Runnable方法来启动线程
 */
public class MyThread04 implements Runnable {
    @Override
    public void run() {
        System.out.println("线程运行中");
    }

    public static void main(String[] args) {
        MyThread04 myThread04 = new MyThread04();

        Thread thread = new Thread(myThread04);

        thread.start();

        System.out.println("运行结束！");
    }
}
