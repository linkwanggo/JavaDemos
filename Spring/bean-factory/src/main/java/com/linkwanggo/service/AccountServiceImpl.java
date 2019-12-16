package com.linkwanggo.service;
import com.linkwanggo.dao.AccountDaoImpl;
import com.linkwanggo.factory.BeanFactory;

import com.linkwanggo.dao.IAccountDao;

public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("accountDao");

    public void saveAccount() {
        accountDao.saveAccount();
    }

}
