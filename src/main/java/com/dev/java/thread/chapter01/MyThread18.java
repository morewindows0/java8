package com.dev.java.thread.chapter01;

/**
 * @author: dengxin.chen
 * @date: 2018/11/9 10:12
 * @description:守护线程
 */
public class MyThread18 extends Thread {

    private int i = 0;

    @Override
    public void run() {
        try {
            while (true) {
                i++;
                System.out.println("i=" + (i));
                Thread.sleep(1000);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            MyThread18 thread18 = new MyThread18();
            thread18.setDaemon(true);
            thread18.start();
            Thread.sleep(5000);
            System.out.println("由于thread18设置为守护线程，当主线程（main线程结束后），thread18线程也就结束了");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
