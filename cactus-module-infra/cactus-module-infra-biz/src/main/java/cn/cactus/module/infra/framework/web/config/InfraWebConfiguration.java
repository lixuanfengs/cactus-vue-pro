package cn.cactus.module.infra.framework.web.config;

import cn.cactus.framework.swagger.config.CactusSwaggerAutoConfiguration;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Package: cn.cactus.module.infra.framework.web.config
 * Description:
 * infra 模块的 web 组件的 Configuration
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 17:35
 * @Github https://github.com/lixuanfengs
 */
@Configuration(proxyBeanMethods = false)
public class InfraWebConfiguration {

    /**
     * infra 模块的 API 分组
     */
    @Bean
    public GroupedOpenApi infraGroupedOpenApi() {
        return CactusSwaggerAutoConfiguration.buildGroupedOpenApi("infra");
    }

}