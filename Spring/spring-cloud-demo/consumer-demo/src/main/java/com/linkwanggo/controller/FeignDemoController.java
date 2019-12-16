package com.linkwanggo.controller;

import com.linkwanggo.client.UserClient;
import com.linkwanggo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feign")
public class FeignDemoController {

    @Autowired
    private UserClient userClient;

    @GetMapping("/user/{id}")
    public User queryById(@PathVariable("id") Long id) {
        return userClient.queryById(id);
    }
}
