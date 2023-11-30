package cn.cactus.framework.errorcode.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Package: cn.cactus.framework.errorcode.config
 * Description:
 * 错误码的配置属性类
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/23 16:18
 * @Github https://github.com/lixuanfengs
 */
@ConfigurationProperties("cactus.error-code")
@Data
@Validated
public class ErrorCodeProperties {

    /**
     * 是否开启
     */
    private Boolean enable = true;
    /**
     * 错误码枚举类
     */
    @NotNull(message = "错误码枚举类不能为空")
    private List<String> constantsClassList;

}