package com.linkwanggo;

import com.linkwanggo.config.SpringConfiguration;
import com.linkwanggo.domain.Tag;
import com.linkwanggo.service.IAccountService;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用Junit单元测试：测试我们的配置
 * Spring整合junit的配置
 *      1、导入spring整合junit的jar(坐标)
 *      2、使用Junit提供的一个注解把原有的main方法替换了，替换成spring提供的
 *             @Runwith
 *      3、告知spring的运行器，spring和ioc创建是基于xml还是注解的，并且说明位置
 *          @ContextConfiguration
 *                  locations：指定xml文件的位置，加上classpath关键字，表示在类路径下
 *                  classes：指定注解类所在地位置
 *
 *   当我们使用spring 5.x版本的时候，要求junit的jar必须是4.12及以上
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class ConfigTest {

    @Autowired
    private IAccountService accountService;

    @Test
    public void testFindLeaf() {
//        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        IAccountService accountService = ac.getBean("accountService", IAccountService.class);

        List<Tag> tagList = this.accountService.findAll();
        System.out.println(tagList.size());
    }

    @Test
    public void testQueryRunner() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        QueryRunner runner = ac.getBean("queryRunner", QueryRunner.class);
        QueryRunner runner2 = ac.getBean("queryRunner", QueryRunner.class);
        System.out.println(runner == runner2);
    }
}
