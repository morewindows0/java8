package com.developer.jdk8.thread.chapter06;

/**
 * @author: dengxin.chen
 * @date: 2018/11/20 15:29
 * @description:懒汉式存在线程安全问题，饿汉式不存在线程安全问题
 */
public class SingletonTest {

    private static volatile SingletonTest object;

    private SingletonTest() {
    }

    //double-check双重检查，保证在多线程环境下为单例
    public static SingletonTest getInstance() {
        try {
            if (object == null) {
                Thread.sleep(1000);
                synchronized (SingletonTest.class) {
                    if (object == null) {
                        object = new SingletonTest();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> System.out.println(SingletonTest.getInstance().hashCode()));
        Thread thread2 = new Thread(() -> System.out.println(SingletonTest.getInstance().hashCode()));
        Thread thread3 = new Thread(() -> System.out.println(SingletonTest.getInstance().hashCode()));
        Thread thread4 = new Thread(() -> System.out.println(SingletonTest.getInstance().hashCode()));
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

    }

}

/**
 * 饿汉式单例模式是不存在线程安全问题的，书中的注解有误
 */
class SingletonHungry {
    private static SingletonHungry object = new SingletonHungry();

    private SingletonHungry() {
    }

    public static SingletonHungry getInstance() {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

   /* public static void main(String[] args) {

        Thread thread1 = new Thread(() -> System.out.println(SingletonHungry.getInstance().hashCode()));
        Thread thread2 = new Thread(() -> System.out.println(SingletonHungry.getInstance().hashCode()));
        Thread thread3 = new Thread(() -> System.out.println(SingletonHungry.getInstance().hashCode()));
        Thread thread4 = new Thread(() -> System.out.println(SingletonHungry.getInstance().hashCode()));
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

    }*/
}
