package com.linkwanggo;

import com.linkwanggo.mapper.AccountMapper;
import com.linkwanggo.mybatis.io.Resources;
import com.linkwanggo.mybatis.sqlsession.SqlSession;
import com.linkwanggo.mybatis.sqlsession.SqlSessionFactory;
import com.linkwanggo.mybatis.sqlsession.SqlSessionFactoryBuilder;
import com.linkwanggo.pojo.Account;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {

    public static void main(String[] args) throws Exception {
        //1.读取配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory的构建者对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //3.使用构建者创建工厂对象SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //4.使用SqlSessionFactory生产SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //5.使用SqlSession创建dao接口的代理对象
        AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
        //6.使用代理对象执行查询所有方法
        List<Account> accountList = accountMapper.findAll();
        accountList.forEach(System.out::println);

    }
}
