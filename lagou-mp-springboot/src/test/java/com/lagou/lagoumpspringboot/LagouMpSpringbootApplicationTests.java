package com.lagou.lagoumpspringboot;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.lagou.mapper.UserMapper;
import com.lagou.pojo.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.jvm.hotspot.opto.HaltNode;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class LagouMpSpringbootApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Test
    void testSelect() {
        List<User> users = userMapper.selectList(null);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    void testInsert(){
        User user = new User();
        user.setAge(18);
        user.setName("zzz123");
        user.setMail("123@qq.vp");

        int insert = userMapper.insert(user);
        System.out.println(user.getId());

    }


   @Test
    void testUpdateById(){
        User user = new User();
        user.setId(6l);
        user.setAge(100);
        userMapper.updateById(user);
    }

    @Test
    void testUpdate(){
        //1.更新的字段
        User user = new User();
        user.setAge(22);
        //2.更新的条件
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name","zzz");


        userMapper.update(user,queryWrapper);
    }


    @Test
    void testUpdate2(){
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id",6).set("age",30);


        userMapper.update(null,updateWrapper);
    }

    @Test
    void testDeleteById(){
        userMapper.deleteById(6l);
    }

    @Test
    void testDeleteByMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","zzz");
        map.put("age",18);
        //将columnMap中的元素设置为了删除条件，多个条件是and关系
        userMapper.deleteByMap(map);
    }

    @Test
    void testDelete(){
        User user = new User();
        user.setName("zzz123");
        user.setAge(18);
        QueryWrapper<User> objectQueryWrapper = new QueryWrapper<>(user);
        //QueryWrapper<User> objectQueryWrapper = new QueryWrapper<>();
        //objectQueryWrapper.eq("name","zzz123").eq("age",18);
        userMapper.delete(objectQueryWrapper);
    }

    @Test
    void testDeleteBatchIds(){
        userMapper.deleteBatchIds(Arrays.asList(7,8));
    }

    @Test
    void testSelectById(){
        userMapper.selectById(1l);
    }

}
