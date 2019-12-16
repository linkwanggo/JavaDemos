package com.linkwanggo.mybatis.sqlsession;

/**
 * 工厂模式
 * SqlSession创建工厂
 */
public interface SqlSessionFactory {

    /**
     * 创建SqlSession实例
     * @return
     */
    SqlSession openSession();

}
