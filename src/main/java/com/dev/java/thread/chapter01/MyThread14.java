package com.dev.java.thread.chapter01;

/**
 * @author: dengxin.chen
 * @date: 2018/11/8 17:19
 * @description:将interrupt与return结合也可以实现停止线程的效果
 */
public class MyThread14 extends Thread {

    @Override
    public void run() {
        while (true) {
            if (this.isInterrupted()) {
                System.out.println("线程停止！");
                return;
            }
            System.out.println("如果线程未停止，则会继续打印");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread14 thread = new MyThread14();
        thread.start();
        Thread.sleep(20);
        thread.interrupt();
    }
}
