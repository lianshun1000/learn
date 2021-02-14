package com.learn.Java8;

import org.junit.Test;

import java.util.Comparator;

public class LambdaTest {
    @Test
    public void test1(){
        Runnable r1 = () -> System.out.println("练顺");
        r1.run();
    }

    @Test
    public void test2(){
        //Lambda表达式写法
        Comparator<Integer> com1 = (o1, o2) -> Integer.compare(o1,o2);
        //方法引用
        Comparator<Integer> com2 = Integer::compare;
    }
}
