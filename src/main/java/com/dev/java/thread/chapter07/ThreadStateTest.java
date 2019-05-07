package com.dev.java.thread.chapter07;

/**
 * @author: dengxin.chen
 * @date: 2018/11/20 16:10
 * @description:线程状态测试
 */
public class ThreadStateTest extends Thread {

    public ThreadStateTest() {
        System.out.println("构造方法中线程的状态," + "线程名：" + Thread.currentThread().getName() + "===" + Thread.currentThread().getState());
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("run方法中线程的状态,线程名:" + Thread.currentThread().getName() + "===" + Thread.currentThread().getState());
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadStateTest thread = new ThreadStateTest();
        //因为构造函数是由main线程调用的
        System.out.println("main方法中线程的状态,线程名：" + Thread.currentThread().getName() + "===" + thread.getState());
        Thread.sleep(1000);
        thread.start();
        Thread.sleep(1000);
        System.out.println("在执行start后main方法中线程的状态,线程名：" + Thread.currentThread().getName() + "===" + thread.getState());
    }
}
