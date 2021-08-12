package com.learn.juc;

import java.util.concurrent.*;

/**
 *
 */
public class MyThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                Runtime.getRuntime().availableProcessors() + 1,//CPU核数+1
                2L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
    }

    private static void initPool() {
        //执行长期任务性能好，创建一个有固定N个线程的线程池，有固定的线程数
        //ExecutorService threadPool = Executors.newFixedThreadPool(5);//一池五个受理线程
        //ExecutorService threadPool = Executors.newSingleThreadExecutor();//一池一个工作线程
        //执行很多短期异步任务，线程池根据需要创建新线程，但在先前创建的线程可用时将重用他们，可扩容
        ExecutorService threadPool = Executors.newCachedThreadPool();//一池N线程

        try {
            //模拟有10个顾客前来办理业务，五个工作人员提供服务
            for (int i = 0; i < 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "办理业务");
                });
                TimeUnit.MILLISECONDS.sleep(400);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
