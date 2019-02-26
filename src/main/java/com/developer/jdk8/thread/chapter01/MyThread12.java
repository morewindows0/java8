package com.developer.jdk8.thread.chapter01;

/**
 * @author: dengxin.chen
 * @date: 2018/11/8 16:15
 * @description:异常法停止线程
 */
public class MyThread12 extends Thread {

    @Override
    public void run() {
        try {
            for (int i = 0; i < 500000; i++) {
                if (this.interrupted()) {
                    System.out.println("线程为停止状态！退出了！");
//                break; //使用break并不能使线程退出，for后面的语句还是会正常输出，在这里直接抛出异常，可正常停止线程

                    throw new InterruptedException("线程停止");

                }
                System.out.println("i=" + (i + 1));
            }
            System.out.println("如果上面break了，我是否为输出！测试证明，我被输出了，线程并未停止，如果使用抛出异常的方法，则线程停止!");
        } catch (InterruptedException e) {
            System.out.println("抛出的异常被catch住，线程停止了.......");
        }


    }

    public static void main(String[] args) throws InterruptedException {
        MyThread12 thread = new MyThread12();
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
        System.out.println("end!");
    }
}
