package com.linkwanggo;

import com.linkwanggo.service.IAroundService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAroundService aroundService = ac.getBean("aroundService", IAroundService.class);
        int res = aroundService.aroundMethod(1);
    }
}
