package cn.cactus.module.system.api.oauth2.dto;

import cn.cactus.framework.common.enums.UserTypeEnum;
import cn.cactus.framework.common.validation.InEnum;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * Package: cn.cactus.module.system.api.oauth2.dto
 * Description:
 * OAuth2.0 访问令牌创建 Request DTO
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/17 11:11
 * @Github https://github.com/lixuanfengs
 */
@Data
public class OAuth2AccessTokenCreateReqDTO implements Serializable {

    /**
     * 用户编号
     */
    @NotNull(message = "用户编号不能为空")
    private Long userId;
    /**
     * 用户类型
     */
    @NotNull(message = "用户类型不能为空")
    @InEnum(value = UserTypeEnum.class, message = "用户类型必须是 {value}")
    private Integer userType;
    /**
     * 客户端编号
     */
    @NotNull(message = "客户端编号不能为空")
    private String clientId;
    /**
     * 授权范围
     */
    private List<String> scopes;
}

