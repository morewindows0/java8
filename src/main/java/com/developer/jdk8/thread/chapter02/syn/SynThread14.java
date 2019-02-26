package com.developer.jdk8.thread.chapter02.syn;

/**
 * @author: dengxin.chen
 * @date: 2018/11/15 11:42
 * @description:
 */
public class SynThread14 extends Thread {

    private ObjectService5 service4;

    public SynThread14(ObjectService5 service4) {
        this.service4 = service4;
    }

    @Override
    public void run() {
        service4.MethodA();
    }

    public static void main(String[] args) {
        ObjectService5 service = new ObjectService5();
        SynThread14 thread = new SynThread14(service);
        thread.start();
        SynThread15 thread15 = new SynThread15(service);
        thread15.start();
    }
}

class SynThread15 extends Thread {
    private ObjectService5 service4;

    public SynThread15(ObjectService5 service4) {
        this.service4 = service4;
    }

    @Override
    public void run() {
        service4.MethodA();
    }
}
