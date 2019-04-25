package com.dev.java.thread.chapter02.syn;

/**
 * @author: dengxin.chen
 * @date: 2018/11/14 14:19
 * @description: synchronized(this)锁定的当前对象
 */
public class Task1 {

    public synchronized void otherMethod() {
        System.out.println("---------run otherMethod");
    }

    public void doLongTimeTask() {
        synchronized (this) {
            for (int i = 0; i < 10000; i++) {
                System.out.println("synchronized threadName=" + Thread.currentThread().getName() + " i=" + (i + 1));
            }
        }
    }
}
