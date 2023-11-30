package cn.cactus.framework.sms.core.property;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Package: cn.cactus.framework.sms.core.property
 * Description:
 * 短信渠道配置类
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 16:29
 * @Github https://github.com/lixuanfengs
 */
@Data
@Validated
public class SmsChannelProperties {

    /**
     * 渠道编号
     */
    @NotNull(message = "短信渠道 ID 不能为空")
    private Long id;
    /**
     * 短信签名
     */
    @NotEmpty(message = "短信签名不能为空")
    private String signature;
    /**
     * 渠道编码
     *
     * 枚举 {@link SmsChannelEnum}
     */
    @NotEmpty(message = "渠道编码不能为空")
    private String code;
    /**
     * 短信 API 的账号
     */
    @NotEmpty(message = "短信 API 的账号不能为空")
    private String apiKey;
    /**
     * 短信 API 的密钥
     */
    @NotEmpty(message = "短信 API 的密钥不能为空")
    private String apiSecret;
    /**
     * 短信发送回调 URL
     */
    private String callbackUrl;
}
