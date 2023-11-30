package cn.cactus.module.system.enums.sms;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Package: cn.cactus.module.system.enums.sms
 * Description:
 * 短信的模板类型枚举
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 10:11
 * @Github https://github.com/lixuanfengs
 */
@Getter
@AllArgsConstructor
public enum SmsTemplateTypeEnum {

    VERIFICATION_CODE(1), // 验证码
    NOTICE(2), // 通知
    PROMOTION(3), // 营销
    ;

    /**
     * 类型
     */
    private final int type;

}
