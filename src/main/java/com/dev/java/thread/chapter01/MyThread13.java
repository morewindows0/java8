package com.dev.java.thread.chapter01;

/**
 * @author: dengxin.chen
 * @date: 2018/11/8 17:05
 * @description:sleep方法，通过interrupt与sleep搭配可以达到停止线程的操作
 */
public class MyThread13 extends Thread {
    @Override
    public void run() {
        try {


            //先sleep，再interrupt
            //先interrupt，再sleep效果是不一样的
            for (int i = 0; i < 1000000; i++) {
                System.out.println("i=" + (i + 1));
            }
            System.out.println("run begin");
            Thread.sleep(200000);
            System.out.println("run end");
        } catch (Exception e) {
            System.out.println("在沉睡中被停止！进入catch! " + this.isInterrupted());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            MyThread13 thread = new MyThread13();
            thread.start();
            thread.interrupt();
        } catch (Exception e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end!");
    }
}
