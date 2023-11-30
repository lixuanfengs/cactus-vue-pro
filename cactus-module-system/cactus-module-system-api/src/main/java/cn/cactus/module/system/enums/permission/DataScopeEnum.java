package cn.cactus.module.system.enums.permission;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Package: cn.cactus.module.system.enums.permission
 * Description:
 * 数据范围枚举类
 *
 * 用于实现数据级别的权限
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 15:51
 * @Github https://github.com/lixuanfengs
 */
@Getter
@AllArgsConstructor
public enum DataScopeEnum {

    ALL(1), // 全部数据权限

    DEPT_CUSTOM(2), // 指定部门数据权限
    DEPT_ONLY(3), // 部门数据权限
    DEPT_AND_CHILD(4), // 部门及以下数据权限

    SELF(5); // 仅本人数据权限

    /**
     * 范围
     */
    private final Integer scope;
}
