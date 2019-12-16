package com.linkwanggo;

import com.linkwanggo.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = ac.getBean("accountService", IAccountService.class);
        accountService.saveAccount();
    }
}
