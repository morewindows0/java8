package com.developer.jdk8.thread.chapter02;

/**
 * @author: dengxin.chen
 * @date: 2018/11/9 11:24
 * @description:验证synchronized取得的是对象锁
 */

class TestObject {

    //当加上synchronized关键字后，方法的执行就是以排队的形式执行，从而得出synchronized获取的是对象的锁
    public synchronized void methodA() {
        try {
            System.out.println("mehtodA begin threadname=" + Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("mehtodA end");

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    public void mehtodB() {
        try {
            System.out.println("mehtodB begin threadname=" + Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("mehtodB end");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}

public class MyThread0302 extends Thread {

    private TestObject object;

    public MyThread0302(TestObject object) {
        this.object = object;
    }

    @Override
    public void run() {
        object.methodA();
    }

    public static void main(String[] args) {
        TestObject object = new TestObject();
        MyThread0302 thread0302 = new MyThread0302(object);
        thread0302.setName("A");
        thread0302.start();
        MyThread0402 thread0402 = new MyThread0402(object);
        thread0402.setName("B");
        thread0402.start();
    }
}

class MyThread0402 extends Thread {
    private TestObject object;

    public MyThread0402(TestObject object) {
        this.object = object;
    }

    @Override
    public void run() {
        object.mehtodB();
    }
}
