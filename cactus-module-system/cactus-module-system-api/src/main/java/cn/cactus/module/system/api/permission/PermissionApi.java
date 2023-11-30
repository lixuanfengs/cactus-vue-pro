package cn.cactus.module.system.api.permission;

import cn.cactus.module.system.api.permission.dto.DeptDataPermissionRespDTO;

import java.util.Collection;
import java.util.Set;

/**
 * Package: cn.cactus.module.system.api.permission
 * Description:
 * 权限 API 接口
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/17 10:58
 * @Github https://github.com/lixuanfengs
 */
public interface PermissionApi {

    /**
     * 获得拥有多个角色的用户编号集合
     *
     * @param roleIds 角色编号集合
     * @return 用户编号集合
     */
    Set<Long> getUserRoleIdListByRoleIds(Collection<Long> roleIds);

    /**
     * 判断是否有权限，任一一个即可
     *
     * @param userId 用户编号
     * @param permissions 权限
     * @return 是否
     */
    boolean hasAnyPermissions(Long userId, String... permissions);

    /**
     * 判断是否有角色，任一一个即可
     *
     * @param userId 用户编号
     * @param roles 角色数组
     * @return 是否
     */
    boolean hasAnyRoles(Long userId, String... roles);

    /**
     * 获得登陆用户的部门数据权限
     *
     * @param userId 用户编号
     * @return 部门数据权限
     */
    DeptDataPermissionRespDTO getDeptDataPermission(Long userId);
}
