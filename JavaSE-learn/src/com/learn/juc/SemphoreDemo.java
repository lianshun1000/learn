package com.learn.juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 信号量：acquire（获取）当一个线程调用acquire时，要么通过成功获取信号量（信号量-1），要么一直等下去，等到有线程释放信号量或者超时
 * release（释放）实际上会将信号量+1，然后唤醒等待的线程
 * <p>
 * 目的：多个共享资源互斥使用
 * 并发线程数的控制
 */
public class SemphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);//模拟资源类，三个空车位

        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "抢占到了");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName() + "离开了");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }
    }
}
