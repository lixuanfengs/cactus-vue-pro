package cn.cactus.module.infra.framework.codegen.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Package: cn.cactus.module.infra.framework.codegen.config
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 17:32
 * @Github https://github.com/lixuanfengs
 */
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(CodegenProperties.class)
public class CodegenConfiguration {
}

