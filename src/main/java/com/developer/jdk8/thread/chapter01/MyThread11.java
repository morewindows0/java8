package com.developer.jdk8.thread.chapter01;

/**
 * @author: dengxin.chen
 * @date: 2018/11/8 15:34
 * @description:停止线程
 */
public class MyThread11 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1; i++) {
            System.out.println("i=" + (i + 1));
        }
    }

    public static void main(String[] args) {
        MyThread11 thread = new MyThread11();
        thread.start();
        thread.interrupt();//这句是为thread对象设置暂停标志
        System.out.println("是否停止1？" + Thread.interrupted()); //判断当前线程是否为中断状态，当前线程为main线程是否停止，会清除停止标志
        System.out.println("是否停止2？" + Thread.interrupted());
        System.out.println("是否停止3？" + thread.isInterrupted());//判断thread线程是否为中断状态，不会清除停止标志
        System.out.println("是否停止4？" + thread.isInterrupted());
    }
}
