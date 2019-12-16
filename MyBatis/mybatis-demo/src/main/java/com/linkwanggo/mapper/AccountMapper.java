package com.linkwanggo.mapper;

import com.linkwanggo.pojo.Account;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccountMapper {

    /**
     * 查询所有账户
     * @return
     */
    List<Account> findAll();

    /**
     * 新增账户
     */
    void saveAccount(Account account);

    /**
     * 更新账户
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除账户
     * @param id
     */
    void deleteAccount(Integer id);

    /**
     * 通过id查询账户
     * @param id
     * @return
     */
    Account findAccountById(Integer id);

    /**
     * 通过用户名模糊查询账户
     * @param username
     * @return
     */
    List<Account> findAccountByUsernameLike(String username);
}
