package com.lagou.mapper;

import com.lagou.pojo.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.cache.impl.PerpetualCache;
import org.mybatis.caches.redis.RedisCache;

import java.util.List;

/**
 * @author lianshun
 * @date 2021/7/22 11:42 下午
 * @description
 */
@CacheNamespace(implementation = RedisCache.class)//开启二级缓存
public interface IUserMapper {
    //查询所有用户信息及其订单信息
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "birthday", column = "birthday"),
            @Result(property = "orderList", column = "id", javaType = List.class,
                    many = @Many(select = "com.lagou.mapper.IOrderMapper.findOrderByUid")),
    })
    @Select("select * from user")
    List<User> findAll();

    //查询所有用户以及其所有角色信息
    @Select("select * from user")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "birthday", column = "birthday"),
            @Result(property = "roleList", column = "id", javaType = List.class,
                    many = @Many(select = "com.lagou.mapper.IRoleMapper.findRoleByUid")),
    })
    List<User> findAllUserAndRole();

    //添加用户
    @Insert("insert into user values (#{id},#{username},#{password},#{birthday})")
    void addUser(User user);

    //更新用户
    @Update("update user set username = #{username} where id = #{id}")
    void updateUser(User user);

    //查询用户
    @Select("select * from user")
    List<User> selectUser();

    //删除用户
    @Delete("delete from user where id = #{id}")
    void deleteUser(Integer id);

    @Options(useCache = true)
    @Select("select * from user where id = #{id}")
    User findUserById(Integer id);
}
