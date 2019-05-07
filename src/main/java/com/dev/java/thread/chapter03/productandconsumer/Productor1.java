package com.dev.java.thread.chapter03.productandconsumer;

/**
 * @author: dengxin.chen
 * @date: 2018/11/19 10:41
 * @description: 生产者消费者模式
 */
class ValueTmp {
    public static String value = "";
}

public class Productor1 {

    private String lock;

    public Productor1(String lock) {
        this.lock = lock;
    }

    public void setValue() {
        try {
            synchronized (lock) {
                if (!ValueTmp.value.equals("")) {
                    lock.wait();
                }
                String value = System.currentTimeMillis() + "_" + System.nanoTime();
                System.out.println("set的值是" + value);
                ValueTmp.value = value;
                lock.notify();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String lock = "";
        Productor1 productor1 = new Productor1(lock);
        Thread product = new Thread(() -> {
            while (true) {
                productor1.setValue();
            }
        });
        Consumer1 consumer1 = new Consumer1(lock);
        Thread consumer = new Thread(() -> {
            while (true) {
                consumer1.getValue();
            }
        });
        product.start();
        consumer.start();
    }
}

class Consumer1 {
    private String lock;

    public Consumer1(String lock) {
        this.lock = lock;
    }

    public void getValue() {
        try {
            synchronized (lock) {
                if (ValueTmp.value.equals("")) {
                    lock.wait();
                }
                System.out.println("get的值是" + ValueTmp.value);
                ValueTmp.value = "";
                lock.notify();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
