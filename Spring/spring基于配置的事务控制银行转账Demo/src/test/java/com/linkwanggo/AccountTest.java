package com.linkwanggo;

import com.linkwanggo.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean.xml")
public class AccountTest {

    @Autowired
    private IAccountService accountService;

    @Test
    public void testTransfer() {
        accountService.transfer("aaa", "bbb", 100f);
    }
}
