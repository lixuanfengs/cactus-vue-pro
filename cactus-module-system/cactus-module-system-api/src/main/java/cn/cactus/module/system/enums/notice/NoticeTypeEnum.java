package cn.cactus.module.system.enums.notice;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Package: cn.cactus.module.system.enums.notice
 * Description:
 * 通知类型
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 15:49
 * @Github https://github.com/lixuanfengs
 */
@Getter
@AllArgsConstructor
public enum NoticeTypeEnum {

    NOTICE(1),
    ANNOUNCEMENT(2);

    /**
     * 类型
     */
    private final Integer type;
}
