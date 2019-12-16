package com.linkwanggo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

public class TransactionConfig {

    /**
     * 用于创建事务管理器对象
     * @param dataSource
     * @return
     */
    @Bean("transactionManager")
    public PlatformTransactionManager getPlatformTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
