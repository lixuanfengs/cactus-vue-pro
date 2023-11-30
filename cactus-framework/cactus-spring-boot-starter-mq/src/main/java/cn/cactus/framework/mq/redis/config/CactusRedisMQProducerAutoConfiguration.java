package cn.cactus.framework.mq.redis.config;

import cn.cactus.framework.mq.redis.core.RedisMQTemplate;
import cn.cactus.framework.mq.redis.core.interceptor.RedisMessageInterceptor;
import cn.cactus.framework.redis.config.CactusRedisAutoConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;

/**
 * Package: cn.cactus.framework.mq.redis.config
 * Description:
 * Redis 消息队列 Producer 配置类
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/29 16:30
 * @Github https://github.com/lixuanfengs
 */
@Slf4j
@AutoConfiguration(after = CactusRedisAutoConfiguration.class)
public class CactusRedisMQProducerAutoConfiguration {

    @Bean
    public RedisMQTemplate redisMQTemplate(StringRedisTemplate redisTemplate,
                                           List<RedisMessageInterceptor> interceptors) {
        RedisMQTemplate redisMQTemplate = new RedisMQTemplate(redisTemplate);
        // 添加拦截器
        interceptors.forEach(redisMQTemplate::addInterceptor);
        return redisMQTemplate;
    }

}
