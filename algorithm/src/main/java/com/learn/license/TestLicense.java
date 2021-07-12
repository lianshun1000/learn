package com.learn.license;

/**
 * @author lianshun
 * @date 2021/6/28 5:30 下午
 * @description
 */
public class TestLicense {
    public static void main(String[] args) throws Exception {
        CreateLicense clicense = new CreateLicense("/createparam.properties");
        clicense.create();
    }
}
