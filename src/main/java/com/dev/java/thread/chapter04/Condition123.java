package com.dev.java.thread.chapter04;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: dengxin.chen
 * @date: 2018/11/20 11:29
 * @description:使用condition顺序执行
 */
public class Condition123 {
    private static volatile int nextPrintWho = 1;
    private static Lock lock = new ReentrantLock();
    private static Condition conditionA = lock.newCondition();
    private static Condition conditionB = lock.newCondition();
    private static Condition conditionC = lock.newCondition();

    public static void main(String[] args) {

        Thread threada = new Thread(() -> {
            try {
                lock.lock();
                while (nextPrintWho != 1) {
                    conditionA.await();
                }
                for (int i = 0; i < 3; i++) {
                    System.out.println("ThreadA " + (i + 1));
                }
                nextPrintWho = 2;
                conditionB.signalAll();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        Thread threadb = new Thread(() -> {
            try {
                lock.lock();
                while (nextPrintWho != 2) {
                    conditionB.await();
                }
                for (int i = 0; i < 3; i++) {
                    System.out.println("ThreadB " + (i + 1));
                }
                nextPrintWho = 3;
                conditionC.signalAll();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        Thread threadc = new Thread(() -> {
            try {
                lock.lock();
                while (nextPrintWho != 3) {
                    conditionC.await();
                }
                for (int i = 0; i < 3; i++) {
                    System.out.println("ThreadC " + (i + 1));
                }
                nextPrintWho = 1;
                conditionA.signalAll();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        Thread[] aArray = new Thread[5];
        Thread[] bArray = new Thread[5];
        Thread[] cArray = new Thread[5];

        for (int i = 0; i < 5; i++) {
            aArray[i] = new Thread(threada);
            bArray[i] = new Thread(threadb);
            cArray[i] = new Thread(threadc);
            aArray[i].start();
            bArray[i].start();
            cArray[i].start();
        }
    }
}
