package com.lagou.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lagou.pojo.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author lianshun
 * @date 2021/7/28 10:38 下午
 * @description
 */
@Component
public interface UserMapper extends BaseMapper<User> {
    List<User> findAll();
}
