package com.developer.jdk8.thread.chapter02.syn;

/**
 * @author: dengxin.chen
 * @date: 2018/11/15 10:44
 * @description:synchronized放在static上和非static上锁定的对象是不一样的
 */
public class ObjectService4 {

    public static synchronized void printA() throws InterruptedException {
        System.out.println("线程" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "进入printA");
        Thread.sleep(3000);
        System.out.println("线程" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "离开printA");
    }

    public static synchronized void printB() {
        System.out.println("线程" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "进入printB");
        System.out.println("线程" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "离开printB");
    }

    public synchronized void printC() {
        System.out.println("线程" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "进入printC");
        System.out.println("线程" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "离开printC");
    }

}
