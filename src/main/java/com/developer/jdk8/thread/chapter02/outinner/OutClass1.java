package com.developer.jdk8.thread.chapter02.outinner;

/**
 * @author: dengxin.chen
 * @date: 2018/11/15 15:23
 * @description:演示对类上锁
 */
public class OutClass1 {

    static class InnerClass1 {
        public void method1(InnerClass2 class2) {
            String threadName = Thread.currentThread().getName();
            synchronized (class2) {
                System.out.println(threadName + "进入innerClass1类中的method1方法");
                for (int i = 0; i < 10; i++) {
                    System.out.println("i=" + i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public synchronized void method2() {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + "进入innerClass1类中的method2方法");
            for (int j = 0; j < 10; j++) {
                System.out.println("j=" + j);

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class InnerClass2 {

        public synchronized void method1() {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + "进入innerClass2类中的method1方法");
            for (int k = 0; k < 10; k++) {
                System.out.println("k=" + k);

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public static void main(String[] args) {
            final InnerClass1 innerClass1 = new InnerClass1();
            final InnerClass2 innerClass2 = new InnerClass2();
            Thread t1 = new Thread(() -> innerClass1.method1(innerClass2), "T1");

            Thread t2 = new Thread(() -> innerClass1.method2(), "T2");

            Thread t3 = new Thread(() -> innerClass2.method1(), "T3");


            t1.start();
            t2.start();
            t3.start();

        }
    }

}
