package cn.cactus.module.system.api.oauth2.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Package: cn.cactus.module.system.api.oauth2.dto
 * Description:
 * OAuth2.0 访问令牌的校验 Response DTO
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/17 11:10
 * @Github https://github.com/lixuanfengs
 */
@Data
public class OAuth2AccessTokenCheckRespDTO implements Serializable {

    /**
     * 用户编号
     */
    private Long userId;
    /**
     * 用户类型
     */
    private Integer userType;
    /**
     * 授权范围的数组
     */
    private List<String> scopes;

}
