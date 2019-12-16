package com.linkwanggo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMVCConfig implements WebMvcConfigurer {

    @Value("${file.winUploadFolder}")
    private String winUploadFolder;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /* 添加对外部静态资源的访问 */
        registry.addResourceHandler("/static/**").addResourceLocations("file:" + winUploadFolder);
    }
}