package com.linkwanggo.controller;

import com.linkwanggo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/cddc/user")
public class ConsumerDemoDiscoveryClient {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id) {
        // 使用discoveryClient从eureka中拉取服务列表
        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
        // 未使用robbin做负载均衡，暂时使用第一个
        ServiceInstance instance = instances.get(0);
        // 获取ip和端口信息
        String baseUrl = "http://"+instance.getHost() + ":" + instance.getPort()+"/user/";
        User user = restTemplate.getForObject(baseUrl + id, User.class);
        System.out.println("user = " + user);
        return user;
    }
}
