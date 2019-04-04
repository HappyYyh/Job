package com.yyh.job.config.view;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * All rights Reserved, Designed By 863044052@qq.com
 *
 * @Package com.yyh.job.config
 * @author: 昊天
 * @date: 2019-03-27 15:01
 * @since V1.1.0-SNAPSHOT
 */
@Configuration
public class CrossOriginConfig extends WebMvcConfigurerAdapter {

    /**
     * 设置跨域
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowCredentials(true);
    }

}
