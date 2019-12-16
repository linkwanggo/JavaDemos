package com.linkwanggo.demo.config;

import config.AppConfig;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "submail.spring-mail")
public class MessageConfig extends AppConfig {
    // 短信模板key
    private String templateKey;

    public String getTemplateKey() {
        return templateKey;
    }

    public void setTemplateKey(String templateKey) {
        this.templateKey = templateKey;
    }
}
