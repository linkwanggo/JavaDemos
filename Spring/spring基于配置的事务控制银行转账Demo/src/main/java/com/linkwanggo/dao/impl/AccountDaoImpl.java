package com.linkwanggo.dao.impl;

import com.linkwanggo.dao.IAccountDao;
import com.linkwanggo.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class AccountDaoImpl implements IAccountDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Account findAccountByName(String username) {
        List<Account> accountList = jdbcTemplate.query("select * from account where username = ?", new BeanPropertyRowMapper<Account>(Account.class), username);
        return accountList.isEmpty() ? null : accountList.get(0);
    }

    public Account findAccountById(Integer accountId) {
        List<Account> accountList = jdbcTemplate.query("select * from account where id = ?", new BeanPropertyRowMapper<Account>(Account.class), accountId);
        if (accountList.isEmpty()) {
            return null;
        }
        if (accountList.size() > 1) {
            throw new RuntimeException("结果集不唯一");
        }
        return accountList.get(0);
    }

    public void updateAccount(Account account) {
        jdbcTemplate.update("update account set username = ?, money = ? where id = ?", account.getUsername(), account.getMoney(), account.getId());
    }
}
