package cn.cactus.framework.errorcode.config;

import cn.cactus.framework.errorcode.core.generator.ErrorCodeAutoGenerator;
import cn.cactus.framework.errorcode.core.generator.ErrorCodeAutoGeneratorImpl;
import cn.cactus.framework.errorcode.core.loader.ErrorCodeLoader;
import cn.cactus.framework.errorcode.core.loader.ErrorCodeLoaderImpl;
import cn.cactus.module.system.api.errorcode.ErrorCodeApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Package: cn.cactus.framework.errorcode.config
 * Description:
 * 错误码配置类
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/23 16:19
 * @Github https://github.com/lixuanfengs
 */
@AutoConfiguration
@ConditionalOnProperty(prefix = "cactus.error-code", value = "enable", matchIfMissing = true) // 允许使用 cactus.error-code.enable=false 禁用访问日志
@EnableConfigurationProperties(ErrorCodeProperties.class)
@EnableScheduling // 开启调度任务的功能，因为 ErrorCodeRemoteLoader 通过定时刷新错误码
public class CactusErrorCodeAutoConfiguration {

    @Bean
    public ErrorCodeAutoGenerator errorCodeAutoGenerator(@Value("${spring.application.name}") String applicationName,
                                                         ErrorCodeProperties errorCodeProperties,
                                                         ErrorCodeApi errorCodeApi) {
        return new ErrorCodeAutoGeneratorImpl(applicationName, errorCodeProperties.getConstantsClassList(), errorCodeApi);
    }

    @Bean
    public ErrorCodeLoader errorCodeLoader(@Value("${spring.application.name}") String applicationName,
                                           ErrorCodeApi errorCodeApi) {
        return new ErrorCodeLoaderImpl(applicationName, errorCodeApi);
    }

}
