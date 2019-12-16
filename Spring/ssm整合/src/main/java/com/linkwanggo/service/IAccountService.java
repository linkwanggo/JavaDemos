package com.linkwanggo.service;

import com.linkwanggo.domain.Account;

import java.util.List;

public interface IAccountService {

    List<Account> findAllAccount();

    void saveAccount(Account account);
}
