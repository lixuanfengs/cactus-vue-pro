package cn.cactus.framework.redis.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

/**
 * Package: cn.cactus.framework.redis.config
 * Description:
 * Cache 配置项
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/16 9:22
 * @Github https://github.com/lixuanfengs
 */
@ConfigurationProperties("cactus.cache")
@Data
@Validated
public class CactusCacheProperties {

    /**
     * {@link #redisScanBatchSize} 默认值
     */
    private static final Integer REDIS_SCAN_BATCH_SIZE_DEFAULT = 30;

    /**
     * redis scan 一次返回数量
     */
    private Integer redisScanBatchSize = REDIS_SCAN_BATCH_SIZE_DEFAULT;
}
