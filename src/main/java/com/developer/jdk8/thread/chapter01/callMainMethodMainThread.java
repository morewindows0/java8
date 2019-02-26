package com.developer.jdk8.thread.chapter01;

/**
 * @author: dengxin.chen
 * @date: 2018/11/8 11:10
 * @description:打印线程的名称
 */
public class callMainMethodMainThread {

    public static void main(String[] args) {
        System.out.println("当前线程名称：" + Thread.currentThread().getName());
    }
}
