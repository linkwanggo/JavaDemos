package com.linkwanggo.utils;

import com.linkwanggo.mybatis.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 数据库连接类
 */
public class DataSourceUtils {

    public static Connection getConnection(Configuration cfg) {
        Connection conn = null;
        try {
            Class.forName(cfg.getDriver());
            conn = DriverManager.getConnection(cfg.getUrl(), cfg.getUsername(), cfg.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
