package com.learn.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

//创建线程的方式四：使用线程池
public class ThreadPool {
    public static void main(String[] args) {
        //1、提供指定线程数量的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) executorService;
        service1.setCorePoolSize(15);
        //2、执行指定的线程操作。需要提供实现Runnable接口或Callable接口实现类的对象
        executorService.execute(new NumberThread());//适合于Runnable
        //executorService.submit();//适合于Callable
        executorService.shutdown();//3、关闭连接池
    }
}


class NumberThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(i);
            }
        }
    }
}
