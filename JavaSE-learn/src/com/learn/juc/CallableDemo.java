package com.learn.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * get方法一般放在最后一行
 */
public class CallableDemo {
    public static void main(String[] args) throws Exception {
        FutureTask<Integer> futureTask = new FutureTask(new MyThread2());

        new Thread(futureTask, "A").start();

        Integer result = futureTask.get();
    }
}

class MyThread implements Runnable {

    @Override
    public void run() {

    }
}

class MyThread2 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("Coming");
        return 1 << 10;
    }
}