package com.linkwanggo.service.impl;

import com.linkwanggo.service.IAccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements IAccountService {

    public void saveAccount() {
        System.out.println("执行保存账户");
    }

    public void updateAccount(int i) {
        System.out.println("执行更新账户：" + i);
    }

    public int deleteAccount() {
        System.out.println("执行删除账户");
        return 0;
    }
}
