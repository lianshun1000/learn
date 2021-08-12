package com.learn.juc;

import com.learn.entities.User;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * 请按照给出的数据，找出同时满足以下条件的数据
 * 偶数ID且，年龄大于24，用户名转为大写，用户名字母倒排序，只输出一个名字
 */
public class StreamDemo {

    public static void main(String[] args) {
        User u1 = new User(11, "a", 23);
        User u2 = new User(12, "b", 24);
        User u3 = new User(13, "c", 22);
        User u4 = new User(14, "d", 28);
        User u5 = new User(16, "e", 26);

        List<User> list = Arrays.asList(u1, u2, u3, u4, u5);

        list.stream().filter(t -> t.getId() % 2 == 0)
                .filter(t -> t.getAge() > 24)
                .map(t -> t.getUserName().toUpperCase())
                .sorted((o1, o2) -> o2.compareTo(o1))
                .limit(1)
                .forEach(System.out::println);
    }


}
