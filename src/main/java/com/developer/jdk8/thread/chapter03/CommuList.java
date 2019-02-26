package com.developer.jdk8.thread.chapter03;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * @author: dengxin.chen
 * @date: 2018/11/16 14:32
 * @description: 线程间通信
 */
public class CommuList {

    private List list = Lists.newArrayList();

    public void add() {
        list.add("test");
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        CommuList list = new CommuList();
        ComThreadA threadA = new ComThreadA(list);
        threadA.setName("A");
        threadA.start();
        ComThreadB threadB = new ComThreadB(list);
        threadB.setName("B");
        threadB.start();
    }
}

class ComThreadA extends Thread {

    private CommuList list;

    public ComThreadA(CommuList list) {
        this.list = list;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                list.add();
                System.out.println("添加了" + (i + 1) + "个元素");
                Thread.sleep(50);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ComThreadB extends Thread {

    private CommuList list;

    public ComThreadB(CommuList list) {
        this.list = list;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println(); //如果这里不加这句，会出现由于循环时间太短而，错过size=5的情况
                if (list.size() == 5) {
                    System.out.println("==5了，线程B退出");
                    throw new InterruptedException();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyList {
    private static List list = Lists.newArrayList();

    public static void add() {
        list.add("anyString");
    }

    public static int size() {
        return list.size();
    }

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        ComThreadC threadC = new ComThreadC(lock);
        threadC.start();
        Thread.sleep(50);
        ComThreadD threadD = new ComThreadD(lock);
        threadD.start();

    }
}

class ComThreadC extends Thread {

    private Object lock;

    public ComThreadC(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                if (MyList.size() != 5) {
                    System.out.println("wait begin" + System.currentTimeMillis());
                    lock.wait();
                    System.out.println("wait end" + System.currentTimeMillis());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ComThreadD extends Thread {

    private Object lock;

    public ComThreadD(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            for (int i = 0; i < 10; i++) {
                MyList.add();
                if (MyList.size() == 5) {
                    lock.notify(); //notify在执行后，并不会立即释放锁，需要将线程执行完后才会释放锁
                    System.out.println("通知已发出");
                }
                System.out.println("添加了" + (i + 1) + "个元素");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

