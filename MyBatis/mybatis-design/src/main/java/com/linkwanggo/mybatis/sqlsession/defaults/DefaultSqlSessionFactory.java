package com.linkwanggo.mybatis.sqlsession.defaults;

import com.linkwanggo.mybatis.cfg.Configuration;
import com.linkwanggo.mybatis.sqlsession.SqlSession;
import com.linkwanggo.mybatis.sqlsession.SqlSessionFactory;

public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration cfg;

    public DefaultSqlSessionFactory(Configuration cfg) {
        this.cfg = cfg;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }
}
