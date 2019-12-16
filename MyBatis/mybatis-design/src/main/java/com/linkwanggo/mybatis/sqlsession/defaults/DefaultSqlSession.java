package com.linkwanggo.mybatis.sqlsession.defaults;

import com.linkwanggo.mybatis.cfg.Configuration;
import com.linkwanggo.mybatis.proxy.MapperProxy;
import com.linkwanggo.mybatis.sqlsession.SqlSession;
import com.linkwanggo.utils.DataSourceUtils;

import java.lang.reflect.Proxy;
import java.sql.Connection;

public class DefaultSqlSession implements SqlSession {

    private Configuration cfg;
    private Connection conn;

    public DefaultSqlSession(Configuration cfg) {
        this.cfg = cfg;
        conn = DataSourceUtils.getConnection(cfg);
    }

    @Override
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        return (T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),
            new Class[]{daoInterfaceClass}, new MapperProxy(cfg.getMappers(), conn));
    }

    @Override
    public void close() {
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
