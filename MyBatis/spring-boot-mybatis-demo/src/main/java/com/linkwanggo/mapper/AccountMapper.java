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
}
