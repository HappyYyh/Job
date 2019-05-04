package com.yyh.job.config.rabbit;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Package com.yyh.job.config
 * @author: 昊天
 * @date: 2019-04-30 19:40
 * @since V1.1.0-SNAPSHOT
 */
@Configuration
public class RabbitMqConfig {

    /**
     * 默认用的是jdk的序列化方式，
     * 现在改成json序列化方法
     * @return
     */
    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}
