package com.yyh.job.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * All rights Reserved, Designed By 863044052@qq.com
 *
 * @Package com.yyh.job.config
 * @author: 昊天
 * @date: 2019-03-27 15:21
 * @since V1.1.0-SNAPSHOT
 */
@Configuration
@EnableAsync
public class ThreadPoolConfig {

    private static final Logger logger = LoggerFactory.getLogger(ThreadPoolConfig.class);

    @Bean
    public Executor taskExecutor(){
        logger.info("开始创建线程池");
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //核心10个
        executor.setCorePoolSize(10);
        //最大容量50个
        executor.setMaxPoolSize(50);
        //允许的空闲时间
        executor.setKeepAliveSeconds(200);
        //缓存队列
        executor.setQueueCapacity(50);
        //设置线程前缀
        executor.setThreadNamePrefix("async-thread-");
        //拒绝策略 当pool已经达到max size的时候，不在新线程中执行任务，而是有调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //初始化
        executor.initialize();
        return executor;
    }
}
