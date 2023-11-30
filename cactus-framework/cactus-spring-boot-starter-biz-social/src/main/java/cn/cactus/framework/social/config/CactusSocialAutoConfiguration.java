package cn.cactus.framework.social.config;

import cn.cactus.framework.social.core.CactusAuthRequestFactory;
import com.xingyuv.http.HttpUtil;
import com.xingyuv.http.support.hutool.HutoolImpl;
import com.xingyuv.jushauth.cache.AuthStateCache;
import com.xingyuv.justauth.autoconfigure.JustAuthProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

/**
 * Package: cn.cactus.framework.social.config
 * Description:
 * 社交自动装配类
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/23 16:28
 * @Github https://github.com/lixuanfengs
 */
@Slf4j
@AutoConfiguration
@EnableConfigurationProperties(JustAuthProperties.class)
public class CactusSocialAutoConfiguration {

    @Bean
    @Primary
    @ConditionalOnProperty(prefix = "justauth", value = "enabled", havingValue = "true", matchIfMissing = true)
    public CactusAuthRequestFactory cactusAuthRequestFactory(JustAuthProperties properties, AuthStateCache authStateCache) {
        // 需要修改 HttpUtil 使用的实现，避免类报错
        HttpUtil.setHttp(new HutoolImpl());
        // 创建 CactusAuthRequestFactory
        return new CactusAuthRequestFactory(properties, authStateCache);
    }

}
