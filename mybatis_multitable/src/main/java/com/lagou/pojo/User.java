package com.lagou.pojo;

import lombok.Data;
import lombok.Generated;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author lianshun
 * @date 2021/7/22 11:06 下午
 * @description
 */
@Data
@Table(name = "user")
public class User implements Serializable {
    @Id//对应的注解的ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)//设置主键的生成策略
    private Integer id;

    private String username;
    private String password;
    private Date birthday;

    //表示该用户具有的所有订单信息
    /*private List<Order> orderList = new ArrayList<>();

    private List<Role> roleList = new ArrayList<>();*/
}
