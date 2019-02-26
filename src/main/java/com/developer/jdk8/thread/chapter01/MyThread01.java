package com.developer.jdk8.thread.chapter01;

/**
 * @author: dengxin.chen
 * @date: 2018/11/8 11:15
 * @description:线程执行的顺序与代码无关-线程调用的随机性
 */
public class MyThread01 extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("MyThread01");
    }

    public static void main(String[] args) {
        MyThread01 myThread = new MyThread01();
        myThread.start();
        System.out.println("运行结束!");
    }
}
