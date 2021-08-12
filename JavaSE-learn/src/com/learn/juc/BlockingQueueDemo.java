package com.learn.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 阻塞队列
 */
public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
        //System.out.println(blockingQueue.add("d"));    //illegalStateException

        blockingQueue.remove();
        blockingQueue.remove();
        blockingQueue.remove();
        //blockingQueue.remove();      //noSuchElementException

        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.element());//查看队首元素
        blockingQueue.remove();


        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        // System.out.println(blockingQueue.offer("d"));  返回false

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());//返回null


        blockingQueue.put("a");
        blockingQueue.put("a");
        blockingQueue.put("a");
        // blockingQueue.put("a");   //阻塞队列已满，则一直阻塞

        blockingQueue.take();
        blockingQueue.take();
        blockingQueue.take();
        //blockingQueue.take();//阻塞队列为空，则一直阻塞


        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        blockingQueue.offer("a", 3L, TimeUnit.SECONDS);


    }
}
