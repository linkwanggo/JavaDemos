package com.linkwanggo.controller;

import com.linkwanggo.domain.Account;
import com.linkwanggo.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @GetMapping("findAllAccount")
    public String findAllAccount() {
        System.out.println("表现层查询所有账户");
        List<Account> accountList = accountService.findAllAccount();
        accountList.forEach(System.out::println);
        return "success";
    }
}
