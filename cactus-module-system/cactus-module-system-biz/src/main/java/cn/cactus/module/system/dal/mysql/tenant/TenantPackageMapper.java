package cn.cactus.module.system.dal.mysql.tenant;

import cn.cactus.framework.common.pojo.PageResult;
import cn.cactus.framework.mybatis.core.mapper.BaseMapperX;
import cn.cactus.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.cactus.module.system.controller.admin.tenant.vo.packages.TenantPackagePageReqVO;
import cn.cactus.module.system.dal.dataobject.tenant.TenantPackageDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Package: cn.cactus.module.system.dal.mysql.tenant
 * Description:
 * 租户套餐 Mapper
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/22 16:27
 * @Github https://github.com/lixuanfengs
 */
@Mapper
public interface TenantPackageMapper extends BaseMapperX<TenantPackageDO> {

    default PageResult<TenantPackageDO> selectPage(TenantPackagePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<TenantPackageDO>()
                .likeIfPresent(TenantPackageDO::getName, reqVO.getName())
                .eqIfPresent(TenantPackageDO::getStatus, reqVO.getStatus())
                .likeIfPresent(TenantPackageDO::getRemark, reqVO.getRemark())
                .betweenIfPresent(TenantPackageDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(TenantPackageDO::getId));
    }

    default List<TenantPackageDO> selectListByStatus(Integer status) {
        return selectList(TenantPackageDO::getStatus, status);
    }
}

