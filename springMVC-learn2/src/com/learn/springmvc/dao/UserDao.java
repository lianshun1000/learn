package com.learn.springmvc.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    public UserDao() {
        System.out.println("UserDao");
    }

    public void hello() {
        System.out.println("Hello");
    }
}
