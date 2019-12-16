package com.linkwanggo.dao;

import org.springframework.stereotype.Repository;

@Repository("accountDao1")
public class AccountDaoImpl implements IAccountDao {

    public void saveAccount() {
        System.out.println("保存用户");
    }

}
