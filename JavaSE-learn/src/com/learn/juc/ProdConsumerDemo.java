package com.learn.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProdConsumerDemo {
    public static void main(String[] args) throws Exception{
        AirCondition airCondition = new AirCondition();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(200);
                    airCondition.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(200);
                    airCondition.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(200);
                    airCondition.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"C").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(200);
                    airCondition.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"D").start();
    }
}

class AirCondition{
    private int number = 0;

    /*public synchronized void increment() throws Exception{
        while(number != 0) {
            wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName()+"    "+number);
        this.notifyAll();

    }

    public synchronized void decrement() throws Exception{
        //判断
        while (number == 0) {
            wait();
        }
        //干活
        number--;
        System.out.println(Thread.currentThread().getName()+"    "+number);
        //通知
        this.notifyAll();
    }*/


    private Lock lock = new ReentrantLock();//可重入非公平的递归锁
    private Condition condition = lock.newCondition();

    public  void increment() throws Exception{
        lock.lock();
        try {
            while(number != 0) {
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName()+"    "+number);
            condition.signal();
        }finally {
            condition.signalAll();
        }

    }

    public  void decrement() throws Exception{
        lock.lock();
        try {
            while(number == 0) {
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName()+"    "+number);
            condition.signal();
        }finally {
            condition.signalAll();
        }
    }
}
