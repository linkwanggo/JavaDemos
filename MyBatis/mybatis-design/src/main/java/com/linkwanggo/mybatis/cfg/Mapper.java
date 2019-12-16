package com.linkwanggo.mybatis.cfg;

import lombok.Data;

/**
 * 封装Mapper配置文件的属性
 */
@Data
public class Mapper {
    private String queryString; // SQL
    private String resultType; // 实体类的全限定类名
}
