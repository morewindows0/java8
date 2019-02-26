package com.developer.jdk8.thread.chapter02.syn;

/**
 * @author: dengxin.chen
 * @date: 2018/11/14 15:17
 * @description:
 */
public class SynThread7 extends Thread {

    private ObjectService1 service;

    public SynThread7(ObjectService1 service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.setUserNameAndPassword("a", "aa");
    }

    public static void main(String[] args) {
        ObjectService1 service = new ObjectService1();
        SynThread7 thread = new SynThread7(service);
        thread.setName("A");
        thread.start();
        SynThread8 thread8 = new SynThread8(service);
        thread8.setName("B");
        thread8.start();
    }
}

class SynThread8 extends Thread {

    private ObjectService1 service;

    public SynThread8(ObjectService1 service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.setUserNameAndPassword("b", "bb");
    }
}
