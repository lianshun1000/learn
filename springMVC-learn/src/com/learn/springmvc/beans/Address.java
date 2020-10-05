package com.learn.springmvc.beans;

public class Address {
    private String province;
    private  String city;

    public Address(String province, String city) {
        this.province = province;
        this.city = city;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Address() {
    }

    public String getProvince() {

        return province;
    }

    @Override
    public String toString() {
        return "Address{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public String getCity() {
        return city;
    }
}
