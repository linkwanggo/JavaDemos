package com.linkwanggo.dao;

import org.springframework.stereotype.Repository;

@Repository("accountDao2")
public class AccountDaoImpl2 implements IAccountDao {

    public void saveAccount() {
        System.out.println("保存用户");
    }

}
