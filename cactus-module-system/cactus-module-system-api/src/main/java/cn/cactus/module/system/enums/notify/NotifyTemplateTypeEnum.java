package cn.cactus.module.system.enums.notify;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Package: cn.cactus.module.system.enums.notify
 * Description:
 * 通知模板类型枚举
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 15:50
 * @Github https://github.com/lixuanfengs
 */
@Getter
@AllArgsConstructor
public enum NotifyTemplateTypeEnum {

    /**
     * 系统消息
     */
    SYSTEM_MESSAGE(2),
    /**
     * 通知消息
     */
    NOTIFICATION_MESSAGE(1);

    private final Integer type;

}