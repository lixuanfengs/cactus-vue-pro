package cn.cactus.module.system.enums.mail;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Package: cn.cactus.module.system.enums.mail
 * Description:
 * 邮件的发送状态枚举
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 15:48
 * @Github https://github.com/lixuanfengs
 */
@Getter
@AllArgsConstructor
public enum MailSendStatusEnum {

    INIT(0), // 初始化
    SUCCESS(10), // 发送成功
    FAILURE(20), // 发送失败
    IGNORE(30), // 忽略，即不发送
    ;

    private final int status;
}
