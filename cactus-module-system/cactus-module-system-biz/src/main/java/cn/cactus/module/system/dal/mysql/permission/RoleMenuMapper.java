package cn.cactus.module.system.dal.mysql.permission;

import cn.cactus.framework.mybatis.core.mapper.BaseMapperX;
import cn.cactus.module.system.dal.dataobject.permission.RoleMenuDO;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;
import java.util.List;

/**
 * Package: cn.cactus.module.system.dal.mysql.permission
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/22 16:21
 * @Github https://github.com/lixuanfengs
 */
@Mapper
public interface RoleMenuMapper extends BaseMapperX<RoleMenuDO> {

    default List<RoleMenuDO> selectListByRoleId(Long roleId) {
        return selectList(RoleMenuDO::getRoleId, roleId);
    }

    default List<RoleMenuDO> selectListByRoleId(Collection<Long> roleIds) {
        return selectList(RoleMenuDO::getRoleId, roleIds);
    }

    default List<RoleMenuDO> selectListByMenuId(Long menuId) {
        return selectList(RoleMenuDO::getMenuId, menuId);
    }

    default void deleteListByRoleIdAndMenuIds(Long roleId, Collection<Long> menuIds) {
        delete(new LambdaQueryWrapper<RoleMenuDO>()
                .eq(RoleMenuDO::getRoleId, roleId)
                .in(RoleMenuDO::getMenuId, menuIds));
    }

    default void deleteListByMenuId(Long menuId) {
        delete(new LambdaQueryWrapper<RoleMenuDO>().eq(RoleMenuDO::getMenuId, menuId));
    }

    default void deleteListByRoleId(Long roleId) {
        delete(new LambdaQueryWrapper<RoleMenuDO>().eq(RoleMenuDO::getRoleId, roleId));
    }

}

