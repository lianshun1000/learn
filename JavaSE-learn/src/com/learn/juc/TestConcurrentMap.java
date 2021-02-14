package com.learn.juc;

import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestConcurrentMap {
    public static void main(String[] args) {
        Map map = new ConcurrentHashMap();
        File file = new File("/Users/lianshun/developer/Tomcat/apache-tomcat-8.5.61/lib");
        for (int i = 0; i < file.listFiles().length; i++) {
            System.out.println(file.listFiles()[i].getName());
        }
    }
}
