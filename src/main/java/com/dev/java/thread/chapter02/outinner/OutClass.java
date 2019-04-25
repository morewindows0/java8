package com.dev.java.thread.chapter02.outinner;

/**
 * @author: dengxin.chen
 * @date: 2018/11/15 15:03
 * @description: 内部类演示
 */
public class OutClass {
    static class Inner {
        public void method1() {
            synchronized ("其他锁") {
                for (int i = 0; i <= 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " i=" + i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public synchronized void method2() {
            for (int i = 0; i <= 20; i++) {
                System.out.println(Thread.currentThread().getName() + " i=" + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        final Inner inner = new Inner();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                inner.method1();
            }
        }, "A");
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                inner.method2();
            }
        }, "B");
        thread1.start();
        thread2.start();


    }
}
