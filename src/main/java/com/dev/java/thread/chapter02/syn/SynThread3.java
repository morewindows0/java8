package com.dev.java.thread.chapter02.syn;

/**
 * @author: dengxin.chen
 * @date: 2018/11/14 11:22
 * @description:
 */
public class SynThread3 extends Thread {
    private ObjectService service;

    public SynThread3(ObjectService service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.serviceMethodA();
    }

    public static void main(String[] args) {
        ObjectService service = new ObjectService();
        SynThread3 thread = new SynThread3(service);
        thread.setName("A");
        thread.start();
        SynThread4 threa4 = new SynThread4(service);
        threa4.setName("B");
        threa4.start();
    }
}

class SynThread4 extends Thread {

    private ObjectService service;


    public SynThread4(ObjectService service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.serviceMethodB();
    }

}
