package cn.cactus.module.system.enums.sms;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Package: cn.cactus.module.system.enums.sms
 * Description:
 * 短信的接收状态枚举
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 10:10
 * @Github https://github.com/lixuanfengs
 */
@Getter
@AllArgsConstructor
public enum SmsReceiveStatusEnum {

    INIT(0), // 初始化
    SUCCESS(10), // 接收成功
    FAILURE(20), // 接收失败
    ;

    private final int status;

}