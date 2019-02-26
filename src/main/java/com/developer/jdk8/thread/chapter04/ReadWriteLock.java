package com.developer.jdk8.thread.chapter04;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: dengxin.chen
 * @date: 2018/11/20 11:42
 * @description:ReentrantReadWriteLock读写锁
 */
public class ReadWriteLock {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void read() {
        try {
            lock.readLock().lock();
//            lock.writeLock().lock();
            System.out.println("获得读锁：" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
//            lock.writeLock().unlock();
        }
    }

    public void write() {
        try {
            lock.writeLock().lock();
            System.out.println("获得写锁：" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }

    public static void main(String[] args) {

        ReadWriteLock readWriteLock = new ReadWriteLock();

        Thread threada = new Thread(() -> readWriteLock.read());
        Thread threadb = new Thread(() -> readWriteLock.write());
        threada.start();
        threadb.start();

    }
}
