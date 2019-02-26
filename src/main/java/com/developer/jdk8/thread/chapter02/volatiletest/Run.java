package com.developer.jdk8.thread.chapter02.volatiletest;

/**
 * @author: dengxin.chen
 * @date: 2018/11/16 10:35
 * @description:
 */
public class Run {
    public static void main(String[] args) {
        PrintString printString = new PrintString();
        new Thread(printString).start();
        System.out.println("我要停止它! stopThread=" + Thread.currentThread().getName());
        printString.setContinuePrint(false);
    }
}
