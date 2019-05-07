package com.dev.java.thread.chapter07;

/**
 * @author: dengxin.chen
 * @date: 2018/11/20 16:25
 * @description:
 */
public class ThreadStateTest2 {

    public synchronized static void serviceMethod() {
        try {
            System.out.println(Thread.currentThread().getName() + "进入了业务方法");
            Thread.sleep(50000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static Object lock = new Object();

    public static void serviceMethod1() {
        try {
            synchronized (lock) {
                lock.wait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) throws InterruptedException {

      /*  Thread a = new Thread(() -> ThreadStateTest2.serviceMethod(), "A");
        a.start();*/

        ThreadGroup group = new ThreadGroup("测试线程组");
        Thread b = new Thread(group, () -> ThreadStateTest2.serviceMethod1(), "B");
        b.start();
        System.out.println("活动的线程数：" + group.activeCount());
        System.out.println("线程组名：" + group.getName());
        Thread.sleep(1000);
        System.out.println("main方法中的B状态：" + b.getState());


    }
}
