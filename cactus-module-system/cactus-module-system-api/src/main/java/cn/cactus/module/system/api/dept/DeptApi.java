package cn.cactus.module.system.api.dept;

import cn.cactus.framework.common.util.collection.CollectionUtils;
import cn.cactus.module.system.api.dept.dto.DeptRespDTO;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Package: cn.cactus.module.system.api.dept
 * Description:
 * 部门 API 接口
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 15:10
 * @Github https://github.com/lixuanfengs
 */
public interface DeptApi {

    /**
     * 获得部门信息
     *
     * @param id 部门编号
     * @return 部门信息
     */
    DeptRespDTO getDept(Long id);

    /**
     * 获得部门信息数组
     *
     * @param ids 部门编号数组
     * @return 部门信息数组
     */
    List<DeptRespDTO> getDeptList(Collection<Long> ids);

    /**
     * 校验部门们是否有效。如下情况，视为无效：
     * 1. 部门编号不存在
     * 2. 部门被禁用
     *
     * @param ids 角色编号数组
     */
    void validateDeptList(Collection<Long> ids);

    /**
     * 获得指定编号的部门 Map
     *
     * @param ids 部门编号数组
     * @return 部门 Map
     */
    default Map<Long, DeptRespDTO> getDeptMap(Set<Long> ids) {
        List<DeptRespDTO> list = getDeptList(ids);
        return CollectionUtils.convertMap(list, DeptRespDTO::getId);
    }

}
