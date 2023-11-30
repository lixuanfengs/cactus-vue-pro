package cn.cactus.framework.lock4j.config;

import com.baomidou.lock.DefaultLockFailureStrategy;
import com.baomidou.lock.spring.boot.autoconfigure.LockAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;

/**
 * Package: cn.cactus.framework.lock4j.config
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/24 15:46
 * @Github https://github.com/lixuanfengs
 */
@AutoConfiguration(before = LockAutoConfiguration.class)
@ConditionalOnClass(name = "com.baomidou.lock.annotation.Lock4j")
public class CactusLock4jConfiguration {

    @Bean
    public DefaultLockFailureStrategy lockFailureStrategy() {
        return new DefaultLockFailureStrategy();
    }

}
