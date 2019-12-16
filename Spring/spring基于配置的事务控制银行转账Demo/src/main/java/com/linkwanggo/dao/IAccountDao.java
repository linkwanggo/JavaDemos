package com.linkwanggo.dao;

import com.linkwanggo.domain.Account;

public interface IAccountDao {

    Account findAccountByName(String username);

    Account findAccountById(Integer accountId);

    void updateAccount(Account account);
}
