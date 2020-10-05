package com.learn.springmvc.beans;

public class Person {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void sayHello(){
        System.out.println("My name is"+ name);
    }
}
