package com.dev.java.thread.chapter02.syn;

/**
 * @author: dengxin.chen
 * @date: 2018/11/15 11:40
 * @description: 演示同步方法造成死循环
 */
public class ObjectService5 {
    public synchronized void MethodA() {
        System.out.println("methodA begin");
        boolean isCondition = true;
        while (isCondition) {

        }
        System.out.println("methodA end");
    }

    public synchronized void MehtodB() {
        System.out.println("methodB begin");
        System.out.println("methodB end");
    }
}
