package cn.cactus.framework.idempotent.config;

import cn.cactus.framework.idempotent.core.aop.IdempotentAspect;
import cn.cactus.framework.idempotent.core.keyresolver.IdempotentKeyResolver;
import cn.cactus.framework.idempotent.core.keyresolver.impl.DefaultIdempotentKeyResolver;
import cn.cactus.framework.idempotent.core.keyresolver.impl.ExpressionIdempotentKeyResolver;
import cn.cactus.framework.idempotent.core.redis.IdempotentRedisDAO;
import cn.cactus.framework.redis.config.CactusRedisAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;

/**
 * Package: cn.cactus.framework.idempotent.config
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/24 15:44
 * @Github https://github.com/lixuanfengs
 */
@AutoConfiguration(after = CactusRedisAutoConfiguration.class)
public class CactusIdempotentConfiguration {

    @Bean
    public IdempotentAspect idempotentAspect(List<IdempotentKeyResolver> keyResolvers, IdempotentRedisDAO idempotentRedisDAO) {
        return new IdempotentAspect(keyResolvers, idempotentRedisDAO);
    }

    @Bean
    public IdempotentRedisDAO idempotentRedisDAO(StringRedisTemplate stringRedisTemplate) {
        return new IdempotentRedisDAO(stringRedisTemplate);
    }

    // ========== 各种 IdempotentKeyResolver Bean ==========

    @Bean
    public DefaultIdempotentKeyResolver defaultIdempotentKeyResolver() {
        return new DefaultIdempotentKeyResolver();
    }

    @Bean
    public ExpressionIdempotentKeyResolver expressionIdempotentKeyResolver() {
        return new ExpressionIdempotentKeyResolver();
    }

}
