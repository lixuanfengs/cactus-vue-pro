package cn.cactus.module.system.api.permission;

import java.util.Collection;

/**
 * Package: cn.cactus.module.system.api.permission
 * Description:
 * 角色 API 接口
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/17 10:59
 * @Github https://github.com/lixuanfengs
 */
public interface RoleApi {

    /**
     * 校验角色们是否有效。如下情况，视为无效：
     * 1. 角色编号不存在
     * 2. 角色被禁用
     *
     * @param ids 角色编号数组
     */
    void validRoleList(Collection<Long> ids);

}
