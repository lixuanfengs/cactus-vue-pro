package cn.cactus.module.system.api.social.dto;

import lombok.Data;

/**
 * Package: cn.cactus.module.system.api.social.dto
 * Description:
 * 微信公众号 JSAPI 签名 Response DTO
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 15:42
 * @Github https://github.com/lixuanfengs
 */
@Data
public class SocialWxJsapiSignatureRespDTO {

    /**
     * 微信公众号的 appId
     */
    private String appId;
    /**
     * 匿名串
     */
    private String nonceStr;
    /**
     * 时间戳
     */
    private Long timestamp;
    /**
     * URL
     */
    private String url;
    /**
     * 签名
     */
    private String signature;


}
