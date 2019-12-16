package com.linkwanggo.service;

import com.linkwanggo.dao.IAccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    public List<Tag> findAll() {
        return accountDao.findAll();
    }

}
