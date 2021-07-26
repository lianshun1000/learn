package com.lagou.mapper;

import com.lagou.pojo.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author lianshun
 * @date 2021/7/23 11:44 下午
 * @description
 */
public interface IRoleMapper{

    @Select("select * from sys_role r,sys_user_role ur where r.id = ur.roleid and ur.userid = #{uid}")
    List<Role> findRoleByUid(Integer uid);
}
