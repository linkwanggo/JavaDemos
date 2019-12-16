package com.linkwanggo.controller;

import com.linkwanggo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/ribbon/user")
public class RibbonConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id) {
        // 使用 service-id + uri, ribbon将自动为我们选取对应服务的真实地址
        String baseUrl = "http://user-service/user/";
        User user = restTemplate.getForObject(baseUrl + id, User.class);
        System.out.println("user = " + user);
        return user;
    }
}
