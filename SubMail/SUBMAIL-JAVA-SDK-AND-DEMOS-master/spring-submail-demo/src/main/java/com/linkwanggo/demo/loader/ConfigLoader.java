package com.linkwanggo.demo.loader;

import com.linkwanggo.demo.config.MessageConfig;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 配置文件加载类
 * 详情参考Submail-Maven-Demo官方Demo
 */
@Data
@Component
@EnableConfigurationProperties(MessageConfig.class)
public class ConfigLoader {

    @Autowired
    private MessageConfig messageConfig;

}
