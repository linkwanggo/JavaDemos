package com.linkwanggo.controller;

import com.linkwanggo.domain.Account;
import com.linkwanggo.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @GetMapping("/findAllAccount")
    public String findAllAccount() {
        List<Account> allAccount = accountService.findAllAccount();
        System.out.println(allAccount);
        return "success";
    }
}
