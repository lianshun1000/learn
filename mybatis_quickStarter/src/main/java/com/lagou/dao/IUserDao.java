package com.lagou.dao;

import com.lagou.pojo.User;

import java.io.IOException;
import java.util.List;

/**
 * @author lianshun
 * @date 2021/7/22 10:01 下午
 * @description
 */
public interface IUserDao {
    public List<User> findAll() throws IOException;

    //多条件组合查询，演示<if>
    List<User> findByCondition(User user);

    //多值查询，演示<foreach>
    List<User> findByIds(Integer[] ids);
}
