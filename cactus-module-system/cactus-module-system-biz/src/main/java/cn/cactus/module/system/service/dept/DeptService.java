package cn.cactus.module.system.service.dept;

import cn.cactus.framework.common.util.collection.CollectionUtils;
import cn.cactus.module.system.controller.admin.dept.vo.dept.DeptCreateReqVO;
import cn.cactus.module.system.controller.admin.dept.vo.dept.DeptListReqVO;
import cn.cactus.module.system.controller.admin.dept.vo.dept.DeptUpdateReqVO;
import cn.cactus.module.system.dal.dataobject.dept.DeptDO;
import cn.hutool.core.collection.CollUtil;

import java.util.*;

/**
 * Package: cn.cactus.module.system.service.dept
 * Description:
 * 部门 Service 接口
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/23 10:19
 * @Github https://github.com/lixuanfengs
 */
public interface DeptService {

    /**
     * 创建部门
     *
     * @param reqVO 部门信息
     * @return 部门编号
     */
    Long createDept(DeptCreateReqVO reqVO);

    /**
     * 更新部门
     *
     * @param reqVO 部门信息
     */
    void updateDept(DeptUpdateReqVO reqVO);

    /**
     * 删除部门
     *
     * @param id 部门编号
     */
    void deleteDept(Long id);

    /**
     * 获得部门信息
     *
     * @param id 部门编号
     * @return 部门信息
     */
    DeptDO getDept(Long id);

    /**
     * 获得部门信息数组
     *
     * @param ids 部门编号数组
     * @return 部门信息数组
     */
    List<DeptDO> getDeptList(Collection<Long> ids);

    /**
     * 筛选部门列表
     *
     * @param reqVO 筛选条件请求 VO
     * @return 部门列表
     */
    List<DeptDO> getDeptList(DeptListReqVO reqVO);

    /**
     * 获得指定编号的部门 Map
     *
     * @param ids 部门编号数组
     * @return 部门 Map
     */
    default Map<Long, DeptDO> getDeptMap(Collection<Long> ids) {
        if (CollUtil.isEmpty(ids)) {
            return Collections.emptyMap();
        }
        List<DeptDO> list = getDeptList(ids);
        return CollectionUtils.convertMap(list, DeptDO::getId);
    }

    /**
     * 获得指定部门的所有子部门
     *
     * @param id 部门编号
     * @return 子部门列表
     */
    List<DeptDO> getChildDeptList(Long id);

    /**
     * 获得所有子部门，从缓存中
     *
     * @param id 父部门编号
     * @return 子部门列表
     */
    Set<Long> getChildDeptIdListFromCache(Long id);

    /**
     * 校验部门们是否有效。如下情况，视为无效：
     * 1. 部门编号不存在
     * 2. 部门被禁用
     *
     * @param ids 角色编号数组
     */
    void validateDeptList(Collection<Long> ids);

}
