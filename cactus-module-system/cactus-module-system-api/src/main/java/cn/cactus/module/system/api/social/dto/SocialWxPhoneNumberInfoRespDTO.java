package cn.cactus.module.system.api.social.dto;

import lombok.Data;

/**
 * Package: cn.cactus.module.system.api.social.dto
 * Description:
 * 微信小程序的手机信息 Response DTO
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 15:43
 * @Github https://github.com/lixuanfengs
 */
@Data
public class SocialWxPhoneNumberInfoRespDTO {

    /**
     * 用户绑定的手机号（国外手机号会有区号）
     */
    private String phoneNumber;

    /**
     * 没有区号的手机号
     */
    private String purePhoneNumber;
    /**
     * 区号
     */
    private String countryCode;

}
