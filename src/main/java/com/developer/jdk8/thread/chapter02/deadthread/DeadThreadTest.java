package com.developer.jdk8.thread.chapter02.deadthread;

/**
 * @author: dengxin.chen
 * @date: 2018/11/15 11:49
 * @description:死锁演示
 */
public class DeadThreadTest implements Runnable {
    private String userName;
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public void run() {
        if (userName.equals("a")) {
            synchronized (lock1) {
                try {
                    System.out.println("username=" + userName);
                    Thread.sleep(3000);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println("按lock1->lock2代码顺序执行");
                }
            }
        }
        if (userName.equals("b")) {
            synchronized (lock2) {
                try {
                    System.out.println("username=" + userName);
                    Thread.sleep(3000);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println("按lock2->lock1代码顺序执行");
                }
            }
        }
    }
}

class TestRun {
    public static void main(String[] args) {
        try {
            DeadThreadTest deadThreadTest = new DeadThreadTest();
            deadThreadTest.setUserName("a");
            Thread thread = new Thread(deadThreadTest);
            thread.start();
            Thread.sleep(100);
            deadThreadTest.setUserName("b");
            Thread thread1 = new Thread(deadThreadTest);
            thread1.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
