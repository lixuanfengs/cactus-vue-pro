package cn.cactus.framework.quartz.config;

import com.alibaba.ttl.TtlRunnable;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * Package: cn.cactus.framework.quartz.config
 * Description:
 * 异步任务 Configuration
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/17 16:21
 * @Github https://github.com/lixuanfengs
 */
@AutoConfiguration
@EnableAsync
public class CactusAsyncAutoConfiguration {

    @Bean
    public BeanPostProcessor threadPoolTaskExecutorBeanPostProcessor() {
        return new BeanPostProcessor() {

            @Override
            public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
                if (!(bean instanceof ThreadPoolTaskExecutor)) {
                    return bean;
                }
                // 修改提交的任务，接入 TransmittableThreadLocal
                ThreadPoolTaskExecutor executor = (ThreadPoolTaskExecutor) bean;
                executor.setTaskDecorator(TtlRunnable::get);
                return executor;
            }

        };
    }
}
