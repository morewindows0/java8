package com.developer.jdk8.thread.chapter01;

/**
 * @author: dengxin.chen
 * @date: 2018/11/8 11:19
 * @description:线程执行的不确定性
 */
public class MyThread02 extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                int time = (int) (Math.random() * 1000);
                Thread.sleep(time);
                System.out.println("run=" + Thread.currentThread().getName());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            MyThread02 thread = new MyThread02();
            thread.setName("myThread02");
            thread.start();
            for (int i = 0; i < 10; i++) {
                int time = (int) (Math.random() * 1000);
                Thread.sleep(time);
                System.out.println("main=" + Thread.currentThread().getName());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
