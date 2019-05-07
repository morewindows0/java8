package com.dev.java.thread.chapter02;

/**
 * @author: dengxin.chen
 * @date: 2018/11/9 14:08
 * @description:synchronized可重入，线程可再次获取锁，在继承环境中可重入锁也是支持的 当一个线程执行的代码出现异常的时候，所持有的锁会自动释放
 */
class Service {
    public synchronized void service1() {
        System.out.println("service1");
        service2();
    }

    public synchronized void service2() {
        System.out.println("service2");
        service3();
    }

    public synchronized void service3() {
        System.out.println("service3");
    }

    public synchronized void service5(String username) {
        if ("a".equals(username)) {
            throw new RuntimeException("出现异常了");
        } else {
            System.out.println("正常执行:" + Thread.currentThread().getName());
        }
    }
}

class SubService extends Service {
    public synchronized void service4() {
        this.service3();
        System.out.println("subService4");
    }

    public void service6() {
        System.out.println("no syn service6");
        this.service3();
    }
}

public class MyThread0602 extends Thread {

    private Service service;

    public MyThread0602() {

    }

    public MyThread0602(Service service) {
        this.service = service;
    }


    @Override
    public void run() {
        /*Service service = new Service();
        service.service1();*/
       /* SubService subService = new SubService();
        subService.service4();*/
       /* if ("A".equals(this.getName())) {
            service.service5("a");
        } else {
            service.service5("b");
        }*/
        SubService sub = new SubService();
        sub.service6();
    }

    public static void main(String[] args) throws InterruptedException {
       /* MyThread0602 thread0602 = new MyThread0602();
        thread0602.start();*/

        //三个方法都被synchronized修饰，当调用service1的时候，内部又进行了
        //方法的链式调用，实验表明，线程还是获取到锁了，因此synchronized是可以重入的
        //不然就会出现死锁
        //可重入锁，在继承关系中也是支持的，子类可通过可重入锁调用父类的同步方法
        //当线程出现异常时，所持有的锁会自动释放

      /*  Service service = new Service();

        MyThread0602 threada = new MyThread0602(service);
        threada.setName("A");
        threada.start();
        Thread.sleep(500);
        MyThread0602 threadb = new MyThread0602(service);
        threadb.setName("B");
        threadb.start();*/

        SubService sub = new SubService();
        MyThread0602 threada = new MyThread0602(sub);
        threada.setName("A");
        threada.start();
        MyThread0602 threadb = new MyThread0602(sub);
        threadb.setName("B");
        threadb.start();


    }

}
