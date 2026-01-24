package com.music.player.framework.trace.config;

import com.music.player.framework.trace.utils.MDCUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/**
 * ClassName : AsyncThreadPoolConfig<br>
 * Description : AsyncThreadPoolConfig<br>
 *
 * @author : sj
 * @date : 1/14/26
 */
@Configuration
public class AsyncThreadPoolConfig {


    @Bean("mdcThreadPool")
    public Executor mdcThreadPool() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor() {
            @Override
            public void execute(Runnable task) {
                super.execute(MDCUtils.wrap(task));
            }

            @Override
            public Future<?> submit(Runnable task) {
                return super.submit(MDCUtils.wrap(task));
            }

            @Override
            public <T> Future<T> submit(Callable<T> task) {
                return super.submit(MDCUtils.wrap(task));
            }
        };

        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(100);
        executor.setThreadNamePrefix("MDC-Async-");
        executor.initialize();
        return executor;
    }

}
