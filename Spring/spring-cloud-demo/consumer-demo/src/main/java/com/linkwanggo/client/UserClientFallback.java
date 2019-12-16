package com.linkwanggo.client;

import com.linkwanggo.pojo.User;
import org.springframework.stereotype.Component;

/**
 * 当服务端出现异常时进入fallback
 */
@Component
public class UserClientFallback implements UserClient {

    @Override
    public User queryById(Long id) {
        User user = new User();
        user.setUsername("未知用户！");
        return user;
    }
}
