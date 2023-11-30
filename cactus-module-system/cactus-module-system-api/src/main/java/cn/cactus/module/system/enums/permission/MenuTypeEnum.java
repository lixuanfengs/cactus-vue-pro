package cn.cactus.module.system.enums.permission;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Package: cn.cactus.module.system.enums.permission
 * Description:
 * 菜单类型枚举类
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 15:51
 * @Github https://github.com/lixuanfengs
 */
@Getter
@AllArgsConstructor
public enum MenuTypeEnum {

    DIR(1), // 目录
    MENU(2), // 菜单
    BUTTON(3) // 按钮
    ;

    /**
     * 类型
     */
    private final Integer type;
}
