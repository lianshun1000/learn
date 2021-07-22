package com.lagou.dao;

import com.lagou.pojo.User;
import org.dom4j.DocumentException;

import java.beans.PropertyVetoException;
import java.util.List;

/**
 * @author lianshun
 * @date 2021/7/22 12:31 上午
 * @description
 */
public interface IUserDao {

    //查询所有用户
    List<User> findAll() throws Exception;

    //根据条件进行用户查询
    User findByCondition(User user) throws Exception;
}
