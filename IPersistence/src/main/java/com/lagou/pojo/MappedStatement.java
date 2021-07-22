package com.lagou.pojo;

import lombok.Data;

/**
 * @author lianshun
 * @date 2021/7/21 8:56 下午
 * @description
 */
@Data
public class MappedStatement {
    //id表识
    private String id;
    //返回值类型
    private String resultType;
    //参数值类型
    private String paramterType;
    //sql语句
    private String sql;
}
