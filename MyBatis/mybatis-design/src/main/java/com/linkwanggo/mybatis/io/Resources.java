package com.linkwanggo.mybatis.io;

import java.io.InputStream;

/**
 * 资源加载类
 * 将配置文件的信息读入InputStream
 */
public class Resources {

    public static InputStream getResourceAsStream(String filePath) {
        return Resources.class.getClassLoader().getResourceAsStream(filePath);
    }
}
