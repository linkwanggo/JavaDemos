package com.linkwanggo.factory;

import com.linkwanggo.service.AccountServiceImpl;
import com.linkwanggo.service.IAccountService;

public class StaticFactory {

    public static IAccountService getAccountService() {
        return new AccountServiceImpl();
    }
}
