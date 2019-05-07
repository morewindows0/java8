package com.dev.java.thread.chapter03.threadlocltest;

import java.util.Date;

/**
 * @author: dengxin.chen
 * @date: 2018/11/19 17:19
 * @description:
 */
public class InheritalbeThreadLocalExt extends InheritableThreadLocal {
    @Override
    protected Object initialValue() {
        return new Date().getTime();
    }

    @Override
    protected Object childValue(Object parentValue) {
        return parentValue + "子线程加数据";
    }
}

class Tools {
    public static InheritalbeThreadLocalExt t1 = new InheritalbeThreadLocalExt();
}

class ThreadA extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("在ThreadA线程中取值=" + Tools.t1.get());
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class TestRun {

    public static void main(String[] args) {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("在Main线程中取值=" + Tools.t1.get());
                Thread.sleep(100);
            }
            Thread.sleep(5000);
            ThreadA threadA = new ThreadA();
            threadA.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
