package cn.cactus.framework.operatelog.config;

import cn.cactus.framework.operatelog.core.aop.OperateLogAspect;
import cn.cactus.framework.operatelog.core.service.OperateLogFrameworkService;
import cn.cactus.framework.operatelog.core.service.OperateLogFrameworkServiceImpl;
import cn.cactus.module.system.api.logger.OperateLogApi;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * Package: cn.cactus.framework.operatelog.config
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 14:54
 * @Github https://github.com/lixuanfengs
 */
@AutoConfiguration
public class CactusOperateLogAutoConfiguration {

    @Bean
    public OperateLogAspect operateLogAspect() {
        return new OperateLogAspect();
    }

    @Bean
    public OperateLogFrameworkService operateLogFrameworkService(OperateLogApi operateLogApi) {
        return new OperateLogFrameworkServiceImpl(operateLogApi);
    }
}
