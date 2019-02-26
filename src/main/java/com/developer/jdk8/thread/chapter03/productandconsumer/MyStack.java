package com.developer.jdk8.thread.chapter03.productandconsumer;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * @author: dengxin.chen
 * @date: 2018/11/19 14:37
 * @description: 多生产多消费等情况
 */
public class MyStack {

    private List list = Lists.newArrayList();

    public synchronized void push() {
        try {
            while (list.size() == 1) {
                this.wait();
            }
            list.add("anyString" + Math.random());
            this.notifyAll();
            System.out.println("push=" + list.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized String pop() {
        String returnValue = "";
        try {
            while (list.size() == 0) {
                System.out.println("pop操作中的：" + Thread.currentThread().getName() + "线程处于wait状态");
                this.wait();
            }
            returnValue = "" + list.get(0);
            list.remove(0);
            this.notifyAll();
            System.out.println("pop=" + list.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnValue;
    }
}

class ProductorMore {

    private MyStack myStack;

    public ProductorMore(MyStack myStack) {
        this.myStack = myStack;
    }

    public void pushService() {
        myStack.push();
    }
}

class ConsumerMore {

    private MyStack myStack;

    public ConsumerMore(MyStack myStack) {
        this.myStack = myStack;
    }

    public void popService() {
        System.out.println("pop=" + myStack.pop());
    }
}

class TestRun {

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        ProductorMore p = new ProductorMore(myStack);
        ConsumerMore c = new ConsumerMore(myStack);
        Thread product1 = new Thread(() -> {
            while (true) {
                p.pushService();
            }
        }, "P1");

        Thread product2 = new Thread(() -> {
            while (true) {
                p.pushService();
            }
        }, "P1");

        Thread consumer = new Thread(() -> {
            while (true) {
                c.popService();
            }
        }, "C");
        Thread consumer1 = new Thread(() -> {
            while (true) {
                c.popService();
            }
        }, "C");

        product1.start();
        product2.start();
        consumer.start();
        consumer1.start();
    }
}
