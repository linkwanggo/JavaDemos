package com.linkwanggo.mybatis.sqlsession;

/**
 * 创建Mapper实例的接口
 */
public interface SqlSession {

    /**
     * 根据mapper接口创建代理对象
     * @param daoInterfaceClass mapper接口
     * @param <T> 接口类型
     * @return 接口实例
     */
    <T> T getMapper(Class<T> daoInterfaceClass);

    /**
     * 释放资源
     */
    void close();
}
