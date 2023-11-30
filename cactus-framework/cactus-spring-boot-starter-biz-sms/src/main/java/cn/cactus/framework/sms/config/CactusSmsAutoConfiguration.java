package cn.cactus.framework.sms.config;

import cn.cactus.framework.sms.core.client.SmsClientFactory;
import cn.cactus.framework.sms.core.client.impl.SmsClientFactoryImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * Package: cn.cactus.framework.sms.config
 * Description:
 * 短信配置类
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 17:09
 * @Github https://github.com/lixuanfengs
 */
@AutoConfiguration
public class CactusSmsAutoConfiguration {

    @Bean
    public SmsClientFactory smsClientFactory() {
        return new SmsClientFactoryImpl();
    }

}
