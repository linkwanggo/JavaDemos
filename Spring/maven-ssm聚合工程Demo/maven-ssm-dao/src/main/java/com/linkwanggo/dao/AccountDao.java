package com.linkwanggo.dao;

import com.linkwanggo.domain.Account;

import java.util.List;

public interface AccountDao {

    List<Account> findAllAccount();

}
