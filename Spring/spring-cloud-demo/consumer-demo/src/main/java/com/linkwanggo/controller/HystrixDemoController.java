package com.linkwanggo.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixDemoController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 测试熔断机制 5次失败后进入open状态，10秒后进入halfopen状态。
     * @param id
     * @return
     */
    @GetMapping("/user/hystrix1/{id}")
    @HystrixCommand(commandProperties = {
            // open --> halfopen 休眠期时间
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            // 请求阈值， 5次失败触发open状态
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
            // 失败占比50%
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50")
    })
    public String queryById(@PathVariable("id") Long id) {
        // 当id为17时，模拟服务器异常
        if (id == 17) {
            throw new RuntimeException("");
        }
        String baseUrl = "http://user-service/user/";
        String user = restTemplate.getForObject(baseUrl + id, String.class);
        System.out.println("user = " + user);
        return user;
    }

    @GetMapping("/user/hystrix/{id}")
    // HystrixCommandProperties类中定义了属性参数
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String queryById2(@PathVariable("id") Long id) {
        // 使用 service-id + uri, ribbon将自动为我们选取对应服务的真实地址
        String baseUrl = "http://user-service/user/hystrix/";
        String user = restTemplate.getForObject(baseUrl + id, String.class);
        System.out.println("user = " + user);
        return user;
    }

    // 服务降级时返回的错误结果
    public String defaultFallback() {
        return "服务器繁忙，请稍后重试";
    }
}
