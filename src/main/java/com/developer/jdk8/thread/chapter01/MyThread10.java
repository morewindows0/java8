package com.developer.jdk8.thread.chapter01;

/**
 * @author: dengxin.chen
 * @date: 2018/11/8 15:09
 * @description:isAlive方法，测试线程是否处于活动状态，当线程已经启动且 尚未终止，就是活动状态，当线程处于正在运行或者准备开始运行的状态，就认为线程是“存活”的
 */
public class MyThread10 extends Thread {

    public MyThread10() {
        System.out.println("MyThread10 Constructor begin");
        System.out.println("Thread.currentThread.getName()=" + Thread.currentThread().getName());
        System.out.println("Thread.currentThread.isAlive=" + Thread.currentThread().isAlive());
        System.out.println("this.getName=" + this.getName());
        System.out.println("this.isAlive=" + this.isAlive());
        System.out.println("MyThread10 Constructor end");
    }

    @Override
    public void run() {
        System.out.println("run begin");
        System.out.println("Thread.currentThread.getName()=" + Thread.currentThread().getName());
        System.out.println("Thread.currentThread.isAlive=" + Thread.currentThread().isAlive());
        System.out.println("this.getName()=" + this.getName());
        System.out.println("this.isAlive=" + this.isAlive());
        System.out.println("run end");

    }

    public static void main(String[] args) throws InterruptedException {
       /* MyThread10 thread = new MyThread10();
        System.out.println("begin=" + thread.isAlive());
        thread.start();
        *//*
           不加睡眠，输出：
           begin=false
           end=true
           run=true
           加上睡眠：
           begin=false
           run=true
           end=false
         *//*
        Thread.sleep(1000);
        System.out.println("end=" + thread.isAlive());*/

        MyThread10 thread = new MyThread10();
        thread.setName("B");
        Thread A = new Thread(thread);
        System.out.println("main begin A isAlive=" + A.isAlive());
        A.setName("A");
        A.start();
        System.out.println("main end A isAlive=" + A.isAlive());

        /*
        MyThread10 Constructor begin
        Thread.currentThread.getName()=main
        Thread.currentThread.isAlive=true
        this.getName=Thread-0
        this.isAlive=false
        MyThread10 Constructor end
        main begin A isAlive=false
        main end A isAlive=true
        run begin
        Thread.currentThread.getName()=A
        Thread.currentThread.isAlive=true
        this.getName()=B 这是将线程对象B以构造参数的形式传递给Thread对象，this表示的线程对象B
        this.isAlive=false 线程对象B，是委派给A线程来代理启动，对B来说为false
        run end
        */
    }
}
