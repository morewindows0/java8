package com.developer.jdk8.thread.chapter02.syn;

/**
 * @author: dengxin.chen
 * @date: 2018/11/14 11:17
 * @description:synchronized代码块将的同步性，synchronized使用的对象监视器是一个
 */
public class ObjectService {
    public void serviceMethodA() {
        try {
            synchronized (this) {
                System.out.println("A begin time=" + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("A end time=" + System.currentTimeMillis());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void serviceMethodB() {
        synchronized (this) {
            System.out.println("B begin time=" + System.currentTimeMillis());
            System.out.println("B end time=" + System.currentTimeMillis());
        }
    }
}
