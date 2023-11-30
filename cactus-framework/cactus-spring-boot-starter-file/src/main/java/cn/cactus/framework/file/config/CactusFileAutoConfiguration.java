package cn.cactus.framework.file.config;

import cn.cactus.framework.file.core.client.FileClientFactory;
import cn.cactus.framework.file.core.client.FileClientFactoryImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * Package: cn.iocoder.yudao.framework.file.config
 * Description:
 * 文件配置类
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/24 15:48
 * @Github https://github.com/lixuanfengs
 */
@AutoConfiguration
public class CactusFileAutoConfiguration {
    @Bean
    public FileClientFactory fileClientFactory() {
        return new FileClientFactoryImpl();
    }
}
