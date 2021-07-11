package com.learn.designPattern.principle.inversion;

public class DependencyInversion2 {
    public static void main(String[] args) {
       Person1 person1 = new Person1();
       person1.receive(new Email1());
       person1.receive(new WeChat1());
    }
}

interface IReceiver{
    String getInfo();
}

class Email1 implements IReceiver{

    @Override
    public String getInfo() {
        return "电子邮件信息：hello";
    }
}

class WeChat1 implements IReceiver{
    @Override
    public String getInfo() {
        return "微信消息：hello";
    }
}

class Person1 {
    public void receive(IReceiver receiver){
        System.out.println(receiver.getInfo());
    }
}