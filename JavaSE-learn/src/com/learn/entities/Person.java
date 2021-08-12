package com.learn.entities;

public class Person implements Cloneable {
    private Integer id;
    private String personName;
    private User user;

    public Person(Integer id, String personName) {
        this.id = id;
        this.personName = personName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
