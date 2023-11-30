package cn.cactus.framework.captcha.config;

import cn.cactus.framework.captcha.core.service.RedisCaptchaServiceImpl;
import com.xingyuv.captcha.properties.AjCaptchaProperties;
import com.xingyuv.captcha.service.CaptchaCacheService;
import com.xingyuv.captcha.service.impl.CaptchaServiceFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;

/**
 * Package: java.cn.cactus.framework.captcha.config
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/17 10:38
 * @Github https://github.com/lixuanfengs
 */
@AutoConfiguration
public class CactusCaptchaConfiguration {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Bean
    public CaptchaCacheService captchaCacheService(AjCaptchaProperties config) {
        // 缓存类型 redis/local/....
        CaptchaCacheService ret = CaptchaServiceFactory.getCache(config.getCacheType().name());
        if (ret instanceof RedisCaptchaServiceImpl) {
            ((RedisCaptchaServiceImpl) ret).setStringRedisTemplate(stringRedisTemplate);
        }
        return ret;
    }
}
