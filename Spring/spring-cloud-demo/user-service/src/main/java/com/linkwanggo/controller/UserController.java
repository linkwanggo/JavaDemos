package com.linkwanggo.controller;

import com.linkwanggo.pojo.User;
import com.linkwanggo.service.UserHystrixService;
import com.linkwanggo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserHystrixService userHystrixService;

    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id) {
        User user = userService.queryById(id);
        return user;
    }

    @GetMapping("/hystrix/{id}")
    public User queryById2(@PathVariable("id") Long id) throws InterruptedException {
        User user = userHystrixService.queryById2(id);
        return user;
    }
}
