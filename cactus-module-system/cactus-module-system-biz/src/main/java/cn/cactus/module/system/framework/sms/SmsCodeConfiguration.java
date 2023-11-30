package cn.cactus.module.system.framework.sms;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Package: cn.cactus.module.system.framework.sms
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/23 10:03
 * @Github https://github.com/lixuanfengs
 */
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(SmsCodeProperties.class)
public class SmsCodeConfiguration {
}
