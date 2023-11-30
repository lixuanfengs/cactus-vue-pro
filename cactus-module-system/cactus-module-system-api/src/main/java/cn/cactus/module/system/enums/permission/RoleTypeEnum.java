package cn.cactus.module.system.enums.permission;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Package: cn.cactus.module.system.enums.permission
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 15:52
 * @Github https://github.com/lixuanfengs
 */
@Getter
@AllArgsConstructor
public enum RoleTypeEnum {

    /**
     * 内置角色
     */
    SYSTEM(1),
    /**
     * 自定义角色
     */
    CUSTOM(2);

    private final Integer type;
}
