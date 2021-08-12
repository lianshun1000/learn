package com.learn.designPattern.principle.inversion;

//依赖倒转原则
public class DependencyInversion1 {
    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());
    }
}

//完成person接受消息

/**
 * 分析：1、简单
 * 2、如果我们获取的对象是短信或者微信，那么需要新增类，person也需新增方法
 * 3、解决思路：引入一个抽象的接口IReceiver,表示接收者，这样Person类与接口发生依赖
 * 由于Email和Weixin都属于接受范围，他们各自实现IReceiver接口，符合依赖倒转原则
 */
class Person {
    public void receive(Email email) {
        System.out.println(email.getInfo());
    }

}

class Email {
    public String getInfo() {
        return "电子邮件信息：hello";
    }
}