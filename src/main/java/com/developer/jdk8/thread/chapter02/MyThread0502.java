package com.developer.jdk8.thread.chapter02;

/**
 * @author: dengxin.chen
 * @date: 2018/11/9 11:48
 * @description:脏读情况
 * 设置值方法为同步，但是获取值方法为非同步，因此线程可以执行getValue方法，此时值还未改变，所以出现脏读的情况，通过synchronized解决
 */
class PublicVar {
    private String username = "A";
    private String password = "AA";

    public synchronized void setValue(String username, String password) {
        try {
            this.username = username;
            Thread.sleep(2000);
            this.password = password;
            System.out.println("setValue method thread name=" + Thread.currentThread().getName() + " username=" + username + " passowrd=" + password);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void getValue() {
        System.out.println("getValue method thread name=" + Thread.currentThread().getName() + " username=" + username + " passowrd=" + password);

    }
}

public class MyThread0502 extends Thread {

    private PublicVar publicVar;

    public MyThread0502(PublicVar publicVar) {
        this.publicVar = publicVar;
    }

    @Override
    public void run() {
        publicVar.setValue("B", "BB");
    }

    public static void main(String[] args) throws InterruptedException {
        PublicVar publicVar = new PublicVar();
        MyThread0502 thread0502 = new MyThread0502(publicVar);
        thread0502.start();
        Thread.sleep(200);
        publicVar.getValue();
    }
}
