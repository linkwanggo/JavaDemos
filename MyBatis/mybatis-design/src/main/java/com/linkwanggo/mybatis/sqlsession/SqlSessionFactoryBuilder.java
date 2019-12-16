package com.linkwanggo.mybatis.sqlsession;

import com.linkwanggo.mybatis.cfg.Configuration;
import com.linkwanggo.mybatis.sqlsession.defaults.DefaultSqlSessionFactory;
import com.linkwanggo.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * 构建者模式
 * 构建SqlSessionFactory工厂
 */
public class SqlSessionFactoryBuilder {

    /**
     * 根据字节输入流构建SqlSessionFactory工厂
     * @param is 字节输入流
     * @return SqlSessionFactory
     */
    public static SqlSessionFactory build(InputStream is) {
        Configuration cfg = XMLConfigBuilder.loadConfiguration(is);
        return new DefaultSqlSessionFactory(cfg);
    }
}
