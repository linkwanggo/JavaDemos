package com.linkwanggo.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisDemo {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void testRedisString() {
        redisTemplate.opsForValue().set("name", "linkwanggo");
        redisTemplate.opsForValue().set("gender", "male");
        String name = redisTemplate.opsForValue().get("name");
        System.out.println("name = " + name);
        String gender = redisTemplate.opsForValue().get("gender");
        System.out.println("gender = " + gender);
    }

    @Test
    public void testRedisList() {
        BoundListOperations<String, String> listOps = redisTemplate.boundListOps("test:list");
        listOps.leftPush("a");
        listOps.leftPush("b");
        listOps.leftPush("c");
        List<String> range = listOps.range(0L, -1L);
        assert range != null;
        range.forEach(System.out::println);
    }

    @Test
    public void testRedisHash() {
        BoundHashOperations<String, String, Object> hashOps = redisTemplate.boundHashOps("test:hash");
        hashOps.put("name", "linkwanggo");
        hashOps.put("age", "22");
        Object name = hashOps.get("name");
        Object age = hashOps.get("age");
        System.out.println("name = " + name);
        System.out.println("age = " + age);
    }

    @Test
    public void testRedisSet() {
        BoundSetOperations<String, String> setOps = redisTemplate.boundSetOps("test:set");
        setOps.add("a");
        setOps.add("b");
        setOps.add("c");
        setOps.add("d");
        Set<String> members = setOps.members();
        assert members != null;
        members.forEach(System.out::println);
    }

    @Test
    public void testRedisZSet() {
        BoundZSetOperations<String, String> zSetOps = redisTemplate.boundZSetOps("test:zset");
        zSetOps.add("lili", 1);
        zSetOps.add("mike", 2);
        zSetOps.add("wuyifan", 0);
        // 从小到大排列
        Set<String> range = zSetOps.rangeByScore(0, 2);
        assert range != null;
        range.forEach(System.out::println);
    }
}
