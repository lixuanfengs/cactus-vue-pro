package cn.cactus.module.system.enums.dept;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Package: cn.cactus.module.system.enums.dept
 * Description:
 * 部门编号枚举
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/23 10:21
 * @Github https://github.com/lixuanfengs
 */
@Getter
@AllArgsConstructor
public enum DeptIdEnum {

    /**
     * 根节点
     */
    ROOT(0L);

    private final Long id;

}
