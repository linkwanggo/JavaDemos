package com.linkwanggo;

import com.linkwanggo.config.SpringConfiguration;
import com.linkwanggo.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
// 全注解时需要使用classes指定主配置类
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountTest {

    @Autowired
    private IAccountService accountService;

    @Test
    public void testTransfer() {
        accountService.transfer("aaa", "bbb", 100f);
    }
}
