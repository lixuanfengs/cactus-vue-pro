package cn.cactus.framework.xss.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import java.util.Collections;
import java.util.List;

/**
 * Package: cn.cactus.framework.xss.config
 * Description:
 * Xss 配置属性
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/17 10:19
 * @Github https://github.com/lixuanfengs
 */
@ConfigurationProperties(prefix = "cactus.xss")
@Validated
@Data
public class XssProperties {

    /**
     * 是否开启，默认为 true
     */
    private boolean enable = true;
    /**
     * 需要排除的 URL，默认为空
     */
    private List<String> excludeUrls = Collections.emptyList();

}
