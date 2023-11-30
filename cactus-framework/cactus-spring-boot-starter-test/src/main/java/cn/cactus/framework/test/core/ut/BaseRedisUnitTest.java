package cn.cactus.framework.test.core.ut;

import cn.cactus.framework.redis.config.CactusRedisAutoConfiguration;
import cn.cactus.framework.test.config.RedisTestConfiguration;
import org.redisson.spring.starter.RedissonAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

/**
 * Package: cn.cactus.framework.test.core.ut
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/14 14:40
 * @Github https://github.com/lixuanfengs
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = BaseRedisUnitTest.Application.class)
@ActiveProfiles("unit-test") // 设置使用 application-unit-test 配置文件
public class BaseRedisUnitTest {

    @Import({
            // Redis 配置类
            RedisTestConfiguration.class, // Redis 测试配置类，用于启动 RedisServer
            RedisAutoConfiguration.class, // Spring Redis 自动配置类
            CactusRedisAutoConfiguration.class, // 自己的 Redis 配置类
            RedissonAutoConfiguration.class, // Redisson 自动高配置类
    })
    public static class Application {
    }

}
