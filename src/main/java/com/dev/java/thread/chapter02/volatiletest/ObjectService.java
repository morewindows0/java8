package com.dev.java.thread.chapter02.volatiletest;

/**
 * @author: dengxin.chen
 * @date: 2018/11/16 11:50
 * @description:
 */
public class ObjectService {

    private boolean isContinueRun = true;

    public void runMethod() {
        String anyString = new String();
        while (isContinueRun) {
            //加了synchronized后，变量的值会从主内存中获取，而不是从线程内存中获取
            synchronized (anyString) {

            }
        }
        System.out.println("停下来");
    }

    public void stopMethod() {
        isContinueRun = false;
    }

    public static void main(String[] args) throws InterruptedException {
        ObjectService service = new ObjectService();
        ThreadA a = new ThreadA(service);
        a.start();
        Thread.sleep(1000);
        ThreadB b = new ThreadB(service);
        b.start();
        System.out.println("已经发起了停止的命令");
    }
}

class ThreadA extends Thread {
    private ObjectService service;

    public ThreadA(ObjectService service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.runMethod();
    }
}

class ThreadB extends Thread {

    private ObjectService service;

    public ThreadB(ObjectService service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.stopMethod();
    }
}
