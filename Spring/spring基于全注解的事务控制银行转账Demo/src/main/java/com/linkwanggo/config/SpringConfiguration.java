package com.linkwanggo.config;

import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 代替bean.xml的作用，实现Spring的全注解配置
 */

@Configuration
@ComponentScan("com.linkwanggo")
@PropertySource("classpath:jdbc.properties")
@EnableTransactionManagement
@Import({JdbcConfig.class, TransactionConfig.class})
public class SpringConfiguration {

}
