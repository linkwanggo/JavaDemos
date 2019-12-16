package com.linkwanggo.dao;

import com.linkwanggo.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IAccountDao {

    @Select("select * from account")
    List<Account> findAllAccount();

    @Insert("insert into account(username, money) values(${username}, ${account})")
    void saveAccount(Account account);
}
