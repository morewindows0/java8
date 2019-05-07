package com.dev.java.thread.chapter02.syn;

/**
 * @author: dengxin.chen
 * @date: 2018/11/14 14:22
 * @description:
 */
public class SynThread5 extends Thread {

    private Task1 task;

    public SynThread5(Task1 task) {
        this.task = task;
    }

    @Override
    public void run() {
        task.doLongTimeTask();
    }

    public static void main(String[] args) throws InterruptedException {
        Task1 task1 = new Task1();

        SynThread5 thread5 = new SynThread5(task1);
        thread5.setName("A");
        thread5.start();
        Thread.sleep(500);
        SynThread6 thread6 = new SynThread6(task1);
        thread6.setName("B");
        thread6.start();
    }
}

class SynThread6 extends Thread {

    private Task1 task;

    public SynThread6(Task1 task) {
        this.task = task;
    }

    @Override
    public void run() {
        task.otherMethod();
    }
}