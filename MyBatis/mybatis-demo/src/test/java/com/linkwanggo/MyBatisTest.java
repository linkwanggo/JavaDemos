package com.linkwanggo;

import com.linkwanggo.mapper.AccountMapper;
import com.linkwanggo.pojo.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MyBatisTest {

    private SqlSession sqlSession;

    private AccountMapper accountMapper;

    private InputStream is;

    /**
     * 初始化mapper
     * @throws Exception
     */
    @Before
    public void init() throws Exception {
        //1.读取配置文件
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory的构建者对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //3.使用构建者创建工厂对象SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //4.使用SqlSessionFactory生产SqlSession对象
        sqlSession = sqlSessionFactory.openSession();
        //5.使用SqlSession创建dao接口的代理对象
        accountMapper = sqlSession.getMapper(AccountMapper.class);
    }

    /**
     * 查询所有
     */
    @Test
    public void findAll() {
        List<Account> accountList = accountMapper.findAll();
        accountList.forEach(System.out::println);
    }

    /**
     * 新增账户
     */
    @Test
    public void saveAccount() {
        Account account = new Account();
        account.setUsername("test6");
        account.setMoney(1000f);
        account.setCreateTime(new Date());
        accountMapper.saveAccount(account);
        // 返回account id
        System.out.println("account = " + account);
    }

    @Test
    public void updateAccount() {
        Account account = new Account();
        account.setId(5);
        account.setUsername("test3");
        account.setMoney(999f);
        account.setCreateTime(new Date());
        accountMapper.updateAccount(account);
        System.out.println("account = " + account);
    }

    @Test
    public void deleteAccount() {
        accountMapper.deleteAccount(3);
    }

    @Test
    public void findAccountById() {
        Account account = accountMapper.findAccountById(4);
        System.out.println("account = " + account);
    }

    @Test
    public void findAccountByUsernameLike() {
        List<Account> accountList = accountMapper.findAccountByUsernameLike("a");
        accountList.forEach(System.out::println);
    }

    /**
     * 提交事务，释放资源
     */
    @After
    public void destroy() {
        try {
            sqlSession.commit();
            sqlSession.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
