package cn.cactus.module.system.enums.logger;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Package: cn.cactus.module.system.enums.logger
 * Description:
 * 登录结果的枚举类
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 10:32
 * @Github https://github.com/lixuanfengs
 */
@Getter
@AllArgsConstructor
public enum LoginResultEnum {

    SUCCESS(0), // 成功
    BAD_CREDENTIALS(10), // 账号或密码不正确
    USER_DISABLED(20), // 用户被禁用
    CAPTCHA_NOT_FOUND(30), // 图片验证码不存在
    CAPTCHA_CODE_ERROR(31), // 图片验证码不正确

    ;

    /**
     * 结果
     */
    private final Integer result;

}
