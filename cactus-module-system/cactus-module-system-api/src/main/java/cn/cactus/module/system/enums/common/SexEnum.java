package cn.cactus.module.system.enums.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Package: cn.cactus.module.system.enums.common
 * Description:
 * 性别的枚举值
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/20 11:19
 * @Github https://github.com/lixuanfengs
 */
@Getter
@AllArgsConstructor
public enum SexEnum {

    /** 男 */
    MALE(1),
    /** 女 */
    FEMALE(2),
    /* 未知 */
    UNKNOWN(3);

    /**
     * 性别
     */
    private final Integer sex;
}
