package cn.cactus.module.system.api.social.dto;

import cn.cactus.framework.common.enums.UserTypeEnum;
import cn.cactus.framework.common.validation.InEnum;
import cn.cactus.module.system.enums.social.SocialTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Package: cn.cactus.module.system.api.social.dto
 * Description:
 * 取消绑定社交用户 Request DTO
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 15:39
 * @Github https://github.com/lixuanfengs
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SocialUserBindReqDTO {

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
     * 授权码
     */
    @NotEmpty(message = "授权码不能为空")
    private String code;
    /**
     * state
     */
    @NotNull(message = "state 不能为空")
    private String state;

}
