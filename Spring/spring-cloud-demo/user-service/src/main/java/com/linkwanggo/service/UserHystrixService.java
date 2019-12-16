package com.linkwanggo.service;

import com.linkwanggo.mapper.UserMapper;
import com.linkwanggo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserHystrixService {

    @Autowired
    private UserMapper userMapper;

    public User queryById2(Long id) throws InterruptedException {
        // 触发hystrix的超时熔断机制
        Thread.sleep(2000);
        return userMapper.selectByPrimaryKey(id);
    }
}
