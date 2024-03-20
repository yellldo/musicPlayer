package com.music.player.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ClassName : ThreadPoolConfig<br>
 * Description : ThreadPoolConfig<br>
 *
 * @author : sj
 * @date : 2024/3/20
 */
@Configuration
public class ThreadPoolConfig {

    @Bean(name = "customAsyncTaskExecutor")
    public ThreadPoolTaskExecutor asyncThreadPoolExecutor() {
        ThreadPoolTaskExecutor asyncThreadPoolExecutor = new ThreadPoolTaskExecutor();
        asyncThreadPoolExecutor.setCorePoolSize(5);
        asyncThreadPoolExecutor.setMaxPoolSize(10);
        asyncThreadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        asyncThreadPoolExecutor.setKeepAliveSeconds(60);
        asyncThreadPoolExecutor.setQueueCapacity(2048);
        asyncThreadPoolExecutor.setThreadNamePrefix("customAsyncTaskExecutor-");
        asyncThreadPoolExecutor.setWaitForTasksToCompleteOnShutdown(true);
        return asyncThreadPoolExecutor;
    }


    @Bean(value = "threadPoolExecutor")
    public ThreadPoolExecutor threadPoolExecutor() {
        return new ThreadPoolExecutor(10, 10, 60L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10000), new ThreadPoolExecutor.CallerRunsPolicy());
    }
}
