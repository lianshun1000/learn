package com.lagou.config;

import com.lagou.utils.ParameterMapping;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lianshun
 * @date 2021/7/21 10:29 下午
 * @description
 */
@Data
public class BoundSql {

    private String sqlText;//解析后的sql

    private List<ParameterMapping> parameterMappingList = new ArrayList<>();

    public BoundSql(String sqlText, List<ParameterMapping> parameterMappingList) {
        this.sqlText = sqlText;
        this.parameterMappingList = parameterMappingList;
    }
}
