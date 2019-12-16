package com.linkwanggo;

import com.linkwanggo.dao.IAccountDao;
import com.linkwanggo.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    /**
     * 获取spring的Ioc核心容器，并根据id获取对象
     *
     * ApplicationContext的三个常用实现类：
     *      ClassPathXmlApplicationContext：它可以加载类路径下的配置文件，要求配置文件必须在类路径下。不在的话，加载不了。(更常用)
     *      FileSystemXmlApplicationContext：它可以加载磁盘任意路径下的配置文件(必须有访问权限）
     *
     *      AnnotationConfigApplicationContext：它是用于读取注解创建容器的，是明天的内容。
     *
     * 核心容器的两个接口引发出的问题：
     *  ApplicationContext:     通过scope属性智能分配单例-多例 单例对象适用              采用此接口
     *      它在构建核心容器时，创建对象采取的策略是采用立即加载的方式。也就是说，只要一读取完配置文件马上就创建配置文件中配置的对象。
     *
     *  BeanFactory:            多例对象使用
     *      它在构建核心容器时，创建对象采取的策略是采用延迟加载的方式。也就是说，什么时候根据id获取对象了，什么时候才真正的创建对象。
     * @param args
     */
    public static void main(String[] args) {

        // 使用ApplicationContext读取bean，加载到ioc容器中
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        IAccountService accountService = ac.getBean("accountService", IAccountService.class);
        IAccountService accountService2 = ac.getBean("accountService2", IAccountService.class);
        IAccountService accountService3 = ac.getBean("accountService3", IAccountService.class);
        System.out.println(accountService);
        System.out.println(accountService2);
        System.out.println(accountService3);
    }
}
