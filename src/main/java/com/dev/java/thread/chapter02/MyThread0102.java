package com.dev.java.thread.chapter02;

/**
 * @author: dengxin.chen
 * @date: 2018/11/9 10:31
 * @description:方法内部的变量为线程安全的，但是如果访问对象的实例对象则可能肯能会出现“非线程安全问题”
 * synchronized取得的是对象的锁
 */
class HasSelfPrivateNum {

    //访问实例对象则可能会出现非线程安全问题，可通过synchronized进行解决
    private int num = 0;

    public void add(String username) {
        try {
            //int num = 0;
            if ("a".equals(username)) {
                num = 100;
                System.out.println("a set over!");
                Thread.sleep(1000);
            } else {
                num = 200;
                System.out.println("b set over!");
            }
            System.out.println(username + " num=" + num);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class MyThread0102 extends Thread {

    private HasSelfPrivateNum hasSelfPrivateNum;

    public MyThread0102(HasSelfPrivateNum hasSelfPrivateNum) {
        this.hasSelfPrivateNum = hasSelfPrivateNum;
    }

    @Override
    public void run() {
        hasSelfPrivateNum.add("a");
    }

    public static void main(String[] args) {
        HasSelfPrivateNum hasSelfPrivateNum = new HasSelfPrivateNum();
        MyThread0102 thread0102 = new MyThread0102(hasSelfPrivateNum);
        thread0102.start();
        MyThread0202 thread0202 = new MyThread0202(hasSelfPrivateNum);
        thread0202.start();
    }

}

class MyThread0202 extends Thread {
    private HasSelfPrivateNum hasSelfPrivateNum;

    public MyThread0202(HasSelfPrivateNum hasSelfPrivateNum) {
        this.hasSelfPrivateNum = hasSelfPrivateNum;
    }

    @Override
    public void run() {
        hasSelfPrivateNum.add("b");
    }
}
