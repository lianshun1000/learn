package com.lagou.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author lianshun
 * @date 2021/7/22 11:07 下午
 * @description
 */
@Data
public class Order implements Serializable {
    private Integer id;
    private String orderTime;
    private Double total;

    //表明该订单属于哪个用户
    private User user;
}
