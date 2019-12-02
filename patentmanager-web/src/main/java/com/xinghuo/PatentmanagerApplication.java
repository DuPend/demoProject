package com.xinghuo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @description: TODO
 * @author: 杜鹏
 * @date: 2019-11-20 17:36
 * @version: V1.0
 */
@SpringBootApplication
public class PatentmanagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(PatentmanagerApplication.class, args);
    }

    /**
     * redis连接池
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "thread.pool")
    public ThreadPoolTaskExecutor getThreadPool() {
        return new ThreadPoolTaskExecutor();
    }
}
