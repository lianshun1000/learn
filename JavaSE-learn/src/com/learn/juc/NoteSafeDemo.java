package com.learn.juc;

import java.sql.SQLOutput;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 1 故障现象
 * java.util.ConcurrentModificationException  并发修改异常
 * 2 导致原因
 * 多线程争抢资源，并未加锁
 * 3 解决方法
 * 3.1  new Vector<>();
 * 3.2  Collections.synchronizedList(new ArrayList<>());
 * 3.3  new CopyOnWriteArrayList<>();写时复制，底层创建volatile的数组，add一个值时扩容+1
 * <p>
 * 4 优化建议
 * 使用JUC的类
 */
public class NoteSafeDemo {
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.remove(1);
        List<String> list = new CopyOnWriteArrayList<>();//Collections.synchronizedList(new ArrayList<>());//new Vector<>();//new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }


        Set<String> set = new CopyOnWriteArraySet<>();//new HashSet<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }


        Map<String, String> map = new ConcurrentHashMap<>();//new HashMap<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 8));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }
    }
}
