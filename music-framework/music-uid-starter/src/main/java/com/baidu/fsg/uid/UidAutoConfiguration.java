package com.baidu.fsg.uid;

import com.baidu.fsg.uid.worker.DisposableWorkerIdAssigner;
import com.baidu.fsg.uid.worker.WorkerIdAssigner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName : UidAutoConfiguration<br>
 * Description : 全局id自动配置<br>
 *
 * @author : sj
 * @date : 2024/9/9
 */
@Configuration
public class UidAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public WorkerIdAssigner workerIdAssigner() {
        return new DisposableWorkerIdAssigner(workerNodeEntity -> {
        });
    }

}
