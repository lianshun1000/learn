package com.lagou.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lianshun
 * @date 2021/7/28 10:35 下午
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("user")
public class User {
    @TableId(type = IdType.AUTO)
    private Long id;
    @TableField(select = false)//查询时不返回该字段的值
    private String name;
    private Integer age;
    @TableField(value = "email")//解决字段名与属性名不一致问题
    private String mail;

    @TableField(exist = false)//表示该字段在数据库中不存在
    private String address;
}
