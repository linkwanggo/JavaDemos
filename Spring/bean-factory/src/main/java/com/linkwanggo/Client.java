package com.linkwanggo;

import com.linkwanggo.factory.BeanFactory;
import com.linkwanggo.service.IAccountService;

public class Client {

    public static void main(String[] args) {

        IAccountService accountService = (IAccountService) BeanFactory.getBean("accountService");
        for (int i = 0; i < 5; i++) {
            System.out.println(accountService);
            accountService.saveAccount();
        }
    }
}
