package cn.cactus.module.system.api.permission;

import cn.cactus.module.system.service.permission.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * Package: cn.cactus.module.system.api.permission
 * Description:
 * 角色 API 实现类
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/23 16:55
 * @Github https://github.com/lixuanfengs
 */
@Service
public class RoleApiImpl implements RoleApi {

    @Resource
    private RoleService roleService;

    @Override
    public void validRoleList(Collection<Long> ids) {
        roleService.validateRoleList(ids);
    }
}
