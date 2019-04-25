package com.dev.java.thread.chapter02.volatiletest;

/**
 * @author: dengxin.chen
 * @date: 2018/11/16 11:14
 * @description:
 */
public class CalCount extends Thread {
    private static int count;

    private synchronized static void addCount() {
        for (int i = 0; i < 100; i++) {
            count++;
        }
        System.out.println(count);
    }

    @Override
    public void run() {
        addCount();
    }

    public static void main(String[] args) {
        CalCount[] threadArray = new CalCount[100];
        for (int i = 0; i < 100; i++) {
            threadArray[i] = new CalCount();
        }
        for (int i = 0; i < 100; i++) {
            threadArray[i].start();
        }
    }
}
