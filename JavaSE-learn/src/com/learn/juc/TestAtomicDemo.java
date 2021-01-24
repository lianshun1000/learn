package com.learn.juc;

import java.util.concurrent.atomic.AtomicInteger;

/*
* 1、i++的原子性问题:i++的操作实际分为三个步骤
* int i = 0
* i = i++   //10
*
* int temp = i;
* i = i+1;
* i = temp;
* */
public class TestAtomicDemo {
    public static void main(String[] args) {
        AtomicDemo atomicDemo = new AtomicDemo();
        for (int i = 0; i < 10; i++) {
            new Thread(atomicDemo).start();
        }

    }
}

class AtomicDemo implements  Runnable
{
    //private int serialNumber = 0;
    private AtomicInteger serialNumber = new AtomicInteger();
    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ":" + getSerialNumber());
    }

    public int getSerialNumber(){
        return serialNumber.getAndIncrement();
    }
}
