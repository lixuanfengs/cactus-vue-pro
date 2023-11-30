package cn.cactus.framework.test.config;

import com.github.fppt.jedismock.RedisServer;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Package: cn.cactus.framework.test.config
 * Description:
 * Redis 测试 Configuration，主要实现内嵌 Redis 的启动
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/14 10:35
 * @Github https://github.com/lixuanfengs
 */
@Configuration(proxyBeanMethods = false)
@Lazy(false) // 禁止延迟加载
@EnableConfigurationProperties(RedisProperties.class)
public class RedisTestConfiguration {

    public RedisServer redisServer(RedisProperties properties) {
        RedisServer redisServer = new RedisServer(properties.getPort());
        // 一次执行多个单元测试时，貌似创建多个 spring 容器，导致不进行 stop。这样，就导致端口被占用，无法启动。。。
        try {
            redisServer.start();
        } catch (Exception ignore) {

        }
        return redisServer;
    }
}
