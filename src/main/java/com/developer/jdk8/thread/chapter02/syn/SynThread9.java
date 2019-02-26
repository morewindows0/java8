package com.developer.jdk8.thread.chapter02.syn;

/**
 * @author: dengxin.chen
 * @date: 2018/11/15 10:06
 * @description:
 */
public class SynThread9 extends Thread {

    private MyOneList list;

    public SynThread9(MyOneList list) {
        this.list = list;
    }

    @Override
    public void run() {
        ObjectService3 service3 = new ObjectService3();
        service3.addServiceMethod(list, "A");
    }

    public static void main(String[] args) throws InterruptedException {

        MyOneList list = new MyOneList();
        SynThread9 thread9 = new SynThread9(list);
        thread9.setName("A");
        thread9.start();
        SynThread10 thread10 = new SynThread10(list);
        thread10.setName("B");
        thread10.start();
        Thread.sleep(3000);
        System.out.println("listSize=" + list.getSize());

    }
}

class SynThread10 extends Thread {

    private MyOneList list;

    public SynThread10(MyOneList list) {
        this.list = list;
    }

    @Override
    public void run() {
        ObjectService3 service3 = new ObjectService3();
        service3.addServiceMethod(list, "B");
    }
}

