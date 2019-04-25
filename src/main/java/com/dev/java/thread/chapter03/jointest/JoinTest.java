package com.dev.java.thread.chapter03.jointest;

/**
 * @author: dengxin.chen
 * @date: 2018/11/19 16:08
 * @description:演示join方法
 */
public class JoinTest extends Thread {
    @Override
    public void run() {
        try {
            int secondValue = (int) (Math.random() * 10000);
            System.out.println(secondValue);
            Thread.sleep(secondValue);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws InterruptedException {

        JoinTest thread = new JoinTest();
        thread.start();
        thread.join();
        System.out.println("当JoinTest线程执行完毕后，才执行这段代码");
    }
}
