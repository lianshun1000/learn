package com.lagou.pojo;

import lombok.Data;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lianshun
 * @date 2021/7/21 8:59 下午
 * @description
 */
@Data
public class Configuration {

    private DataSource dataSource;

    /**
     * key:statementId
     * value:封装好的MappedStatement对象
     */
    Map<String,MappedStatement> mappedStatementMap = new HashMap<>();
}
