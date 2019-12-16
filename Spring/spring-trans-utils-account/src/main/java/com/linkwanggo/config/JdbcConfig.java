package com.linkwanggo.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;

@Configuration
public class JdbcConfig {

    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    @Bean
    @Scope("prototype")
    public QueryRunner queryRunner(DataSource dataSource) {
        return new QueryRunner(dataSource);
    }

    @Bean
    public DataSource dataSource() {
        try {
            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            dataSource.setDriverClass(driver);
            dataSource.setJdbcUrl(url);
            dataSource.setUser(username);
            dataSource.setPassword(password);
            return dataSource;
        } catch (Exception e) {
            throw new RuntimeException("dataSource创建失败");
        }
    }
}
