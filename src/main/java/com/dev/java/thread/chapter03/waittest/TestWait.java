package com.dev.java.thread.chapter03.waittest;

/**
 * @author: dengxin.chen
 * @date: 2018/11/16 15:15
 * @description:
 */
public class TestWait {

    public static void main(String[] args) throws InterruptedException {
        String string = new String();
        string.wait(); //wait方法必须在同步代码块中，这样才会有对象监视器，也就是锁
    }
}
