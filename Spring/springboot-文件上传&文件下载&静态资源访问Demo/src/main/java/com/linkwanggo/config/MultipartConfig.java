package com.linkwanggo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;
import java.io.File;
import java.util.Map;

/**
 * 系统加载时配置文件上传属性
 * 1. 指定文件上传的BasePath
 */
@Configuration
public class MultipartConfig {

    @Value("${file.winUploadFolder}")
    private String winUploadFolder;

    @Value("${file.macUploadFolder}")
    private String macUploadFolder;

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        Map<String, String> envMap = System.getenv();
        String osName = envMap.get("OS");
        if (osName.toLowerCase().startsWith("win")) {
            // 创建文件存放目录
            File winUploadFolderFile = new File(winUploadFolder);
            if (!winUploadFolderFile.exists()) {
                winUploadFolderFile.mkdirs();
            }
            factory.setLocation(winUploadFolder);
        } else {
            // TODO: 2019/10/30 mac及linux下配置
        }
        return factory.createMultipartConfig();
    }
}
