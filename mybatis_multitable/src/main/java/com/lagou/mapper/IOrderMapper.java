package com.lagou.mapper;

import com.lagou.pojo.Order;
import com.lagou.pojo.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author lianshun
 * @date 2021/7/22 11:10 下午
 * @description
 */

public interface IOrderMapper {
    //查询订单的同时，查询该订单所属用户
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "total", column = "total"),
            @Result(property = "user", column = "uid", javaType = User.class, one = @One(select = "com.lagou.mapper.IUserMapper.findUserById"))
    })
    @Select("select * from orders")
    List<Order> findOrderAndUser();


    @Select("select * from orders where uid = #{uid}")
    List<Order> findOrderByUid(Integer uid);
}
