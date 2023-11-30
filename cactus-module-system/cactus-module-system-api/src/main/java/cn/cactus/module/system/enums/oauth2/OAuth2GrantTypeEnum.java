package cn.cactus.module.system.enums.oauth2;

import cn.hutool.core.util.ArrayUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Package: cn.cactus.module.system.enums.oauth2
 * Description:
 * OAuth2 授权类型（模式）的枚举
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/20 10:52
 * @Github https://github.com/lixuanfengs
 */
@AllArgsConstructor
@Getter
public enum OAuth2GrantTypeEnum {

    PASSWORD("password"), // 密码模式
    AUTHORIZATION_CODE("authorization_code"), // 授权码模式
    IMPLICIT("implicit"), // 简化模式
    CLIENT_CREDENTIALS("client_credentials"), // 客户端模式
    REFRESH_TOKEN("refresh_token"), // 刷新模式
    ;

    private final String grantType;

    public static OAuth2GrantTypeEnum getByGranType(String grantType) {
        return ArrayUtil.firstMatch(o -> o.getGrantType().equals(grantType), values());
    }

}
