package cn.cactus.module.system.enums.logger;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Package: cn.cactus.module.system.enums.logger
 * Description:
 * 登录日志的类型枚举
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 10:31
 * @Github https://github.com/lixuanfengs
 */
@Getter
@AllArgsConstructor
public enum LoginLogTypeEnum {

    LOGIN_USERNAME(100), // 使用账号登录
    LOGIN_SOCIAL(101), // 使用社交登录
    LOGIN_MOBILE(103), // 使用手机登陆
    LOGIN_SMS(104), // 使用短信登陆

    LOGOUT_SELF(200),  // 自己主动登出
    LOGOUT_DELETE(202), // 强制退出
    ;

    /**
     * 日志类型
     */
    private final Integer type;

}
