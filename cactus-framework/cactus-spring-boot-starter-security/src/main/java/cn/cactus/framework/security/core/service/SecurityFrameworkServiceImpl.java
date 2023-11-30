package cn.cactus.framework.security.core.service;

import cn.cactus.framework.security.core.LoginUser;
import cn.cactus.framework.security.core.util.SecurityFrameworkUtils;
import cn.cactus.module.system.api.permission.PermissionApi;
import cn.hutool.core.collection.CollUtil;
import lombok.AllArgsConstructor;

import java.util.Arrays;

import static cn.cactus.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

/**
 * Package: cn.cactus.framework.security.core.service
 * Description:
 * 默认的 {@link SecurityFrameworkService} 实现类
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/17 10:56
 * @Github https://github.com/lixuanfengs
 */
@AllArgsConstructor
public class SecurityFrameworkServiceImpl implements  SecurityFrameworkService {

    private final PermissionApi permissionApi;

    @Override
    public boolean hasPermission(String permission) {
        return hasAnyPermissions(permission);
    }

    @Override
    public boolean hasAnyPermissions(String... permissions) {
        return permissionApi.hasAnyPermissions(getLoginUserId(), permissions);
    }

    @Override
    public boolean hasRole(String role) {
        return hasAnyRoles(role);
    }

    @Override
    public boolean hasAnyRoles(String... roles) {
        return permissionApi.hasAnyRoles(getLoginUserId(), roles);
    }

    @Override
    public boolean hasScope(String scope) {
        return hasAnyScopes(scope);
    }

    @Override
    public boolean hasAnyScopes(String... scope) {
        LoginUser user = SecurityFrameworkUtils.getLoginUser();
        if (user == null) {
            return false;
        }
        return CollUtil.containsAny(user.getScopes(), Arrays.asList(scope));
    }
}
