package com.music.player.framework.prometheus.config;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName : PrometheusMetricsConfiguration<br>
 * Description : PrometheusMetricsConfiguration<br>
 *
 * @author : sj
 * @date : 1/18/26
 */
@Slf4j
@Configuration
@ConditionalOnClass(value = MeterRegistry.class)
@ConditionalOnProperty(value = "management.metrics.export.prometheus.enabled", havingValue = "true")
public class PrometheusMetricsConfiguration {


    @Bean
    MeterRegistryCustomizer<MeterRegistry> configurer(
            @Value("${spring.application.name}") String applicationName) {
        log.info("上报 tag");
        return (registry) -> registry.config().commonTags("Application", applicationName);
    }

}


