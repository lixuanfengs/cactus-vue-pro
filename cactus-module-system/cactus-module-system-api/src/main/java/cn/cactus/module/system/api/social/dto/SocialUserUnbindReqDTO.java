package cn.cactus.module.system.api.social.dto;

import cn.cactus.framework.common.enums.UserTypeEnum;
import cn.cactus.framework.common.validation.InEnum;
import cn.cactus.module.system.enums.social.SocialTypeEnum;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Package: cn.cactus.module.system.api.social.dto
 * Description:
 * 社交绑定 Request DTO，使用 code 授权码
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 15:41
 * @Github https://github.com/lixuanfengs
 */
@Data
public class SocialUserUnbindReqDTO {

    /**
     * 用户编号
     */
    @NotNull(message = "用户编号不能为空")
    private Long userId;
    /**
     * 用户类型
     */
    @InEnum(UserTypeEnum.class)
    @NotNull(message = "用户类型不能为空")
    private Integer userType;

    /**
     * 社交平台的类型
     */
    @InEnum(SocialTypeEnum.class)
    @NotNull(message = "社交平台的类型不能为空")
    private Integer socialType;

    /**
     * 社交平台的 openid
     */
    @NotEmpty(message = "社交平台的 openid 不能为空")
    private String openid;

}
