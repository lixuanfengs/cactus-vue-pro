package cn.cactus.framework.tracer.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Package: cn.cactus.framework.tracer.config
 * Description:
 * BizTracer配置类
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 15:11
 * @Github https://github.com/lixuanfengs
 */
@ConfigurationProperties("cactus.tracer")
@Data
public class TracerProperties {
}
