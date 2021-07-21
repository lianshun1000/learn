package com.lagou.test;

import com.lagou.io.Resources;

import java.io.InputStream;

/**
 * @author lianshun
 * @date 2021/7/21 1:23 上午
 * @description
 */
public class IPersistenceTest {

    public void test(){
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
    }



}
