package com.dev.java.thread.chapter02.syn;

/**
 * @author: dengxin.chen
 * @date: 2018/11/15 10:48
 * @description:
 */
public class SynThread11 extends Thread {
    private ObjectService4 service4;

    public SynThread11(ObjectService4 service4) {
        this.service4 = service4;
    }

    @Override
    public void run() {
        try {
            service4.printA();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ObjectService4 service4 = new ObjectService4();
        SynThread11 thread11 = new SynThread11(service4);
        thread11.setName("A");
        thread11.start();
        SynThread12 thread12 = new SynThread12(service4);
        thread12.setName("B");
        thread12.start();
        SynThread13 thread13 = new SynThread13(service4);
        thread13.setName("C");
        thread13.start();

       /*
        synchronized放在static上锁定的是class类上锁，直接放在方法上是对对象上锁
        线程A在1542250437900进入printA
        线程C在1542250437900进入printC
        线程C在1542250437901离开printC
        线程A在1542250440900离开printA
        线程B在1542250440900进入printB
        线程B在1542250440901离开printB
        */
    }
}

class SynThread12 extends Thread {
    private ObjectService4 service4;

    public SynThread12(ObjectService4 service4) {
        this.service4 = service4;
    }

    @Override
    public void run() {
        service4.printB();
    }
}

class SynThread13 extends Thread {
    private ObjectService4 service4;

    public SynThread13(ObjectService4 service4) {
        this.service4 = service4;
    }

    @Override
    public void run() {
        service4.printC();
    }
}
