package com.developer.jdk8.thread.chapter03.waittest;

/**
 * @author: dengxin.chen
 * @date: 2018/11/19 9:46
 * @description:
 */
public class AddNotify {
    private String lock;

    public AddNotify(String lock) {
        this.lock = lock;
    }

    public void add() {
        synchronized (lock) {
            ValueObject.list.add("anyString");
            lock.notifyAll();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        String lock = new String("");
        SubtractWait subtractWait = new SubtractWait(lock);
        Thread thread1 = new Thread(() -> subtractWait.sub(), "A");
        Thread thread2 = new Thread(() -> subtractWait.sub(), "B");
        thread1.start();
        thread2.start();
        Thread.sleep(1000);
        AddNotify add = new AddNotify(lock);
        Thread thread3 = new Thread(() -> add.add(), "C");
        thread3.start();

    }
}

class SubtractWait {

    private String lock;

    public SubtractWait(String lock) {
        this.lock = lock;
    }

    public void sub() {
        try {
            synchronized (lock) {
                while (ValueObject.list.size() == 0) {
                    System.out.println("wait begin ThreadName=" + Thread.currentThread().getName());
                    lock.wait();
                    System.out.println("wait end ThreadName=" + Thread.currentThread().getName());
                }
                ValueObject.list.remove(0);
                System.out.println("list size=" + ValueObject.list.size());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
