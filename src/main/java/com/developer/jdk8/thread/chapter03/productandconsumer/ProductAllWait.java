package com.developer.jdk8.thread.chapter03.productandconsumer;

/**
 * @author: dengxin.chen
 * @date: 2018/11/19 10:56
 * @description: 多生产多些消费---假死的情况
 */
class ValueAllWaitTmp {
    public static String value = "";
}

public class ProductAllWait {

    private String lock;

    public ProductAllWait(String lock) {
        this.lock = lock;
    }

    public void setValue() {
        try {
            synchronized (lock) {
                while (!ValueAllWaitTmp.value.equals("")) {
                    System.out.println("生产者 " + Thread.currentThread().getName() + " WAITING了★");
                    lock.wait();
                }
                System.out.println("生产者 " + Thread.currentThread().getName() + " RUNNABLE了");
                String value = System.currentTimeMillis() + "_" + System.nanoTime();
                ValueAllWaitTmp.value = value;
                lock.notify();
//                lock.notifyAll(); //解决假死的情况，使用notifyAll
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        String lock = "";
        ProductAllWait p = new ProductAllWait(lock);
        ConsumerAllWait c = new ConsumerAllWait(lock);
        Thread[] pThread = new Thread[2];
        Thread[] cThread = new Thread[2];

        for (int i = 0; i < 2; i++) {
            pThread[i] = new Thread(() -> {
                while (true) {
                    p.setValue();
                }
            }, "生产者" + (i + 1));
            cThread[i] = new Thread(() -> {
                while (true) {
                    c.getValue();
                }
            }, "消费者" + (i + 1));
            pThread[i].start();
            cThread[i].start();
        }

        Thread.sleep(5000);
        Thread[] threadArray = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
        Thread.currentThread().getThreadGroup().enumerate(threadArray);
        for (int i = 0; i < threadArray.length; i++) {
            System.out.println(threadArray[i].getName() + " " + threadArray[i].getState());
        }
        /**
         * 产生假死的原因：同类唤醒
         *
         */
        /*
        生产者 生产者2 RUNNABLE了  //生产者2 生产后，发出通知，过早通知，无效
        生产者 生产者2 WAITING了★ //生产者2 进入下一次循环，发现产品未被消费，则wait
        生产者 生产者1 WAITING了★ //此时生产者1进来，产品同样未被消费，也wait
        消费者 消费者2 RUNNABLE了 //消费者2进行消费，该消费者会唤醒 生产者2
        消费者 消费者2 WAITING了☆ //消费者2迅速进入下一次循环，然后wait，释放锁
        消费者 消费者1 WAITING了☆ //消费者1进入后，无产品也wait
        生产者 生产者2 RUNNABLE了  此时生产者2醒了，唤醒了生产者1
        生产者 生产者2 WAITING了★ 产品未被消费，则wait
        生产者 生产者1 WAITING了★ 生产者1被唤醒，发现产品为被消费，则wait，这是线程都wait了，则出现假死
        */


    }

}

class ConsumerAllWait {

    private String lock;

    public ConsumerAllWait(String lock) {
        this.lock = lock;
    }

    public void getValue() {
        try {
            synchronized (lock) {
                while (ValueAllWaitTmp.value.equals("")) {
                    System.out.println("消费者 " + Thread.currentThread().getName() + " WAITING了☆");
                    lock.wait();
                }
                System.out.println("消费者 " + Thread.currentThread().getName() + " RUNNABLE了");
                ValueAllWaitTmp.value = "";
                lock.notify();
//                lock.notifyAll();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
