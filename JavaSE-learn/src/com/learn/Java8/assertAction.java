package com.learn.Java8;

import org.junit.Test;

import java.util.LinkedList;

public class assertAction {
    public static void main(String[] args) {
        //不生效：main不是使用的java -ea xxx方式运行程序，assert会被忽略
        assert 1 == 0;
        System.out.println("断言生效");
    }

    @Test
    public void testAssert() {
        assert 1 == 0;
        System.out.println("断言生效");
    }
}
