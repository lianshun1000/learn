package com.learn.juc;

import com.learn.entities.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 *  1  标准访问，先打印邮件还是短信  先邮件，后短信
 *  2  邮件方法暂停四秒   先邮件，后短信
 *  3  邮件方法暂停四秒,新增普通sayHello()方法(不带synchronized)  先sayHello，后邮件
 *  4  两部手机   先短信，后邮件
 *  5  两个静态同步方法，一部手机   先邮件，后短信
 *  6  两个静态同步方法，两部手机   先邮件，后短信
 *  7  一个静态同步方法，一个普通同步方法，一部手机
 *  7  一个静态同步方法，一个普通同步方法，两部手机
 *
 *
 *
 * 1，2 一个对象里面如果有多个synchronized方法，某一时刻类，只要有一个线程去调用了其中一个synchronized方法，其他线程都只能等待
 *  锁的是当前对象this，被锁之后，其他线程都不能进入当前对象的其他synchronized方法
 *
 *  3 普通方法则与synchronized方法无关，不参与竞争资源
 *
 *  4，7，8 换成两个对象，不再是同一把锁
 *
 *  5，6 静态同步方法，锁的是当前类的class对象
 */
public class Lock8Demo {
    public static void main(String[] args) throws InterruptedException, CloneNotSupportedException {
        Phone phone = new Phone();
        Phone phone2 = new Phone();

        HashMap map = new HashMap();
        map.put(1,2);
        HashMap map2 = (HashMap) map.clone();

        System.out.println(map == map2);
        map.put(1,3);
        System.out.println( map2);
        System.out.println( map);

        /*Person p1 = new Person(1,"123");
        Person p2 = (Person) p1.clone();

        System.out.println(p1.getId());
        System.out.println(p2.getId());

        p1.setId(2);
        System.out.println(p1.getId());
        System.out.println(p2.getId());*/



        new Thread(() -> {
            try {
                phone.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"a").start();

        Thread.sleep(100);

        new Thread(() -> {
            try {
               // phone.sendMsg();  //1,2，5，7
               // phone.sayHello(); //3
               // phone2.sendMsg();//4，6，8

            } catch (Exception e) {
                e.printStackTrace();
            }
        },"b").start();

    }
}

class Phone{
    public synchronized void sendEmail() throws Exception{   //5，6，7，8 static
        TimeUnit.SECONDS.sleep(4);
        System.out.println("sendEmail");
    }

    public synchronized void sendMsg() throws Exception{  //5，6  static
        System.out.println("sendMsg");
    }

    public  void sayHello() throws Exception{
        System.out.println("sayHello");
    }
}