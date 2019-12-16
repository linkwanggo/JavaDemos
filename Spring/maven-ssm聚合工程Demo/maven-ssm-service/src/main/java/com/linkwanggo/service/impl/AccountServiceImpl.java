package com.linkwanggo.service.impl;

import com.linkwanggo.service.IAccountService;
import com.linkwanggo.dao.AccountDao;
import com.linkwanggo.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountDao accountDao;

    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }
}
