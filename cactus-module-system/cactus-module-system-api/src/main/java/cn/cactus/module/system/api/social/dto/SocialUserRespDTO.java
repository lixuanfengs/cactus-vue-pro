package cn.cactus.module.system.api.social.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Package: cn.cactus.module.system.api.social.dto
 * Description:
 * 社交用户 Response DTO
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 15:40
 * @Github https://github.com/lixuanfengs
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SocialUserRespDTO {

    /**
     * 社交用户 openid
     */
    private String openid;

    /**
     * 关联的用户编号
     */
    private Long userId;

}
