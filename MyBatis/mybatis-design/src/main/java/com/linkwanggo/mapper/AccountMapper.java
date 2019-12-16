package com.linkwanggo.mapper;

import com.linkwanggo.pojo.Account;

import java.util.List;

public interface AccountMapper {

    /**
     * 查询所有账户
     * @return
     */
    List<Account> findAll();
}
