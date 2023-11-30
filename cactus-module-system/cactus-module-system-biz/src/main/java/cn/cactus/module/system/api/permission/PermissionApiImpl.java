package cn.cactus.module.system.api.permission;

import cn.cactus.module.system.api.permission.dto.DeptDataPermissionRespDTO;
import cn.cactus.module.system.service.permission.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Set;

/**
 * Package: cn.cactus.module.system.api.permission
 * Description:
 * 权限 API 实现类
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/23 16:55
 * @Github https://github.com/lixuanfengs
 */
@Service
public class PermissionApiImpl implements PermissionApi {

    @Resource
    private PermissionService permissionService;

    @Override
    public Set<Long> getUserRoleIdListByRoleIds(Collection<Long> roleIds) {
        return permissionService.getUserRoleIdListByRoleId(roleIds);
    }

    @Override
    public boolean hasAnyPermissions(Long userId, String... permissions) {
        return permissionService.hasAnyPermissions(userId, permissions);
    }

    @Override
    public boolean hasAnyRoles(Long userId, String... roles) {
        return permissionService.hasAnyRoles(userId, roles);
    }

    @Override
    public DeptDataPermissionRespDTO getDeptDataPermission(Long userId) {
        return permissionService.getDeptDataPermission(userId);
    }

}
