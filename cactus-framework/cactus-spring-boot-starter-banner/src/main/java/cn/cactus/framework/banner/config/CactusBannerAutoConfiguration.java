package cn.cactus.framework.banner.config;

import cn.cactus.framework.banner.core.BannerApplicationRunner;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * Package: cn.cactus.framework.banner.config
 * Description:
 * Banner 的自动配置类
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/10 18:00
 * @Github https://github.com/lixuanfengs
 */
@AutoConfiguration
public class CactusBannerAutoConfiguration {

    @Bean
    public BannerApplicationRunner bannerApplicationRunner() {
        return new BannerApplicationRunner();
    }
}
