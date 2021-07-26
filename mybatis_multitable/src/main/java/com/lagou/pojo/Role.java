package com.lagou.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author lianshun
 * @date 2021/7/22 11:57 下午
 * @description
 */
@Data
public class Role implements Serializable {
    private Integer id;
    private String roleName;
    private String roleDesc;
}
