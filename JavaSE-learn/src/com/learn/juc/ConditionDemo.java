package com.learn.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程之间按顺序调用
 * A打印5次，B打印10次，C打印15次
 */
public class ConditionDemo {
    public static void main(String[] args) {
        ShareDate shareDate = new ShareDate();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    shareDate.print5();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    shareDate.print10();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    shareDate.print15();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"C").start();
    }
}

class ShareDate{
    private int number = 1;//A:1  B:2   C:3
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void print5() throws Exception{
        lock.lock();
        try {
            while (number != 1){
               c1.await();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()+"    "+i);
            }
            number = 2;
            //如何通知第二个
            c2.signal();
        }finally {
            lock.unlock();
        }
    }


    public void print10() throws Exception{
        lock.lock();
        try {
            while (number != 2){
                c2.await();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+"    "+i);
            }
            number = 3;
            //如何通知第二个
            c3.signal();
        }finally {
            lock.unlock();
        }
    }



    public void print15() throws Exception{
        lock.lock();
        try {
            while (number != 3){
                c3.await();
            }
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName()+"    "+i);
            }
            number = 1;
            //如何通知第二个
            c1.signal();
        }finally {
            lock.unlock();
        }
    }
}