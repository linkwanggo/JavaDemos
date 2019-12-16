package com.linkwanggo.mybatis;

import com.linkwanggo.mapper.AccountMapper;
import com.linkwanggo.pojo.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountMapperTest {

    @Autowired
    private AccountMapper accountMapper;

    @Test
    public void testFindAll() {
        List<Account> accountList = accountMapper.findAll();
        accountList.forEach(System.out::println);
    }
}
