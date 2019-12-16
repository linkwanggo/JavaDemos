package com.linkwanggo.service.impl;

import com.linkwanggo.dao.IAccountDao;
import com.linkwanggo.domain.Account;
import com.linkwanggo.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    @Override
    public List<Account> findAllAccount() {
        System.out.println("业务层查询所有账户");
        return accountDao.findAllAccount();
    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("业务层保存账户");
    }
}
