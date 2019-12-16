package com.linkwanggo.mybatis.proxy;

import com.linkwanggo.mybatis.cfg.Mapper;
import com.linkwanggo.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

public class MapperProxy implements InvocationHandler {

    private Map<String, Mapper> mappers;
    private Connection conn;

    public MapperProxy(Map<String, Mapper> mappers, Connection conn) {
        this.mappers = mappers;
        this.conn = conn;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 获取方法名
        String methodName = method.getName();
        // 获取全类名
        String className = method.getDeclaringClass().getName();
        // 拼接 key
        String key = className + "." + methodName;
        // 从mappers中查找key所对应的mapper
        Mapper mapper = mappers.get(key);
        if (mapper == null) {
            throw new IllegalArgumentException("无效的key");
        }
        // 调用工具类执行selectList方法
        return new Executor().selectList(mapper, conn);
    }
}
