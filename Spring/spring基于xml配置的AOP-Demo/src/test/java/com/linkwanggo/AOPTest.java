package com.linkwanggo;

import com.linkwanggo.service.IAccountService;
import com.linkwanggo.service.IAroundService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        IAccountService accountService = ac.getBean("accountService", IAccountService.class);
//        accountService.saveAccount();
//        accountService.updateAccount(1);
//        accountService.deleteAccount();
        // 环绕通知测试代码
        IAroundService aroundService = ac.getBean("aroundService", IAroundService.class);
        int res = aroundService.aroundMethod(1);

    }
}
