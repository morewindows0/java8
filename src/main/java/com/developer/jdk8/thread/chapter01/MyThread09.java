package com.developer.jdk8.thread.chapter01;

/**
 * @author: dengxin.chen
 * @date: 2018/11/8 14:38
 * @description:
 */
public class MyThread09 extends Thread {

    public MyThread09() {
        System.out.println("MyThread09 Constructor begin");
        System.out.println("Thread.currentThread.getName()=" + Thread.currentThread().getName());
        System.out.println("this.getName()=" + this.getName());
        System.out.println("MyThread09 Constructor end");
    }

    @Override
    public void run() {
        System.out.println("run begin");
        System.out.println("Thread.currentThread.getName()=" + Thread.currentThread().getName());
        System.out.println("this.getName()=" + this.getName());
        System.out.println("run end");

    }

    public static void main(String[] args) {
        MyThread09 thread = new MyThread09();
        thread.setName("B");
        Thread thread1 = new Thread(thread);
        thread1.setName("A");
        thread1.start();


        /*
        输出值如下：
        MyThread09 Constructor begin
        Thread.currentThread.getName()=main
        this.getName()=Thread-0
        MyThread09 Constructor end

        run begin
        Thread.currentThread.getName()=A
        this.getName()=B
        run end

        理解：
        #1.MyThread09的构造函数是有主线程在调用所以当前线程为main
        #2.this.getName为当前对象的线程
        public Thread() {
        init(null, null, "Thread-" + nextThreadNum(), 0);
        }
        此时还未设置线程名称的，所以为Thread-0
        #3.在run方法中，由于将线程B委托给A调用所以，当前执行的线程为A
        #4.this.Name=B，由于线程B已经执行，当前线程对象为B，所以这里显示为B
        */


    }
}
