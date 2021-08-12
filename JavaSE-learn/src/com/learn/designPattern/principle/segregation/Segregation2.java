package com.learn.designPattern.principle.segregation;

public class Segregation2 {
    public static void main(String[] args) {
        classA classA = new classA();
        classA.depend1(new classB());//A类通过接口依赖B类
        classA.depend2(new classB());//A类通过接口依赖B类
        classA.depend3(new classB());//A类通过接口依赖B类

        classC classC = new classC();
        classC.depend1(new classD());//A类通过接口依赖B类
        classC.depend4(new classD());//A类通过接口依赖B类
        classC.depend5(new classD());//A类通过接口依赖B类


    }
}

interface InterfaceA1 {
    void operation1();
}

interface InterfaceA2 {
    void operation2();

    void operation3();
}

interface InterfaceA3 {
    void operation4();

    void operation5();
}

class classB implements InterfaceA1, InterfaceA2 {

    @Override
    public void operation1() {
        System.out.println("B实现了operation1");
    }

    @Override
    public void operation2() {
        System.out.println("B实现了operation2");
    }

    @Override
    public void operation3() {
        System.out.println("B实现了operation3");
    }
}

class classD implements InterfaceA1, InterfaceA3 {

    @Override
    public void operation1() {
        System.out.println("D实现了operation1");
    }

    @Override
    public void operation4() {
        System.out.println("D实现了operation4");
    }

    @Override
    public void operation5() {
        System.out.println("D实现了operation5");
    }
}


class classA {
    public void depend1(InterfaceA1 i) {
        i.operation1();
    }

    public void depend2(InterfaceA2 i) {
        i.operation2();
    }

    public void depend3(InterfaceA2 i) {
        i.operation3();
    }
}

class classC {
    public void depend1(InterfaceA1 i) {
        i.operation1();
    }

    public void depend4(InterfaceA3 i) {
        i.operation4();
    }

    public void depend5(InterfaceA3 i) {
        i.operation5();
    }
}