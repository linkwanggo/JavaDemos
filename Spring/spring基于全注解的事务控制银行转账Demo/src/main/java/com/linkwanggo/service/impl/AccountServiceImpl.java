package com.linkwanggo.service.impl;

import com.linkwanggo.dao.IAccountDao;
import com.linkwanggo.domain.Account;
import com.linkwanggo.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    /**
     * 转账操作
     * @param sourceName
     * @param targetName
     * @param money
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void transfer(String sourceName, String targetName, Float money) {
        Account source = accountDao.findAccountByName(sourceName);
        Account target = accountDao.findAccountByName(targetName);
        source.setMoney(source.getMoney() - money);
        target.setMoney(target.getMoney() + money);
        accountDao.updateAccount(source);
        int i = 1 / 0;
        accountDao.updateAccount(target);
    }
}
