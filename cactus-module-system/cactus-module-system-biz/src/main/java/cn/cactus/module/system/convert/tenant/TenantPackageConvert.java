package cn.cactus.module.system.convert.tenant;

import cn.cactus.framework.common.pojo.PageResult;
import cn.cactus.module.system.controller.admin.tenant.vo.packages.TenantPackageCreateReqVO;
import cn.cactus.module.system.controller.admin.tenant.vo.packages.TenantPackageRespVO;
import cn.cactus.module.system.controller.admin.tenant.vo.packages.TenantPackageSimpleRespVO;
import cn.cactus.module.system.controller.admin.tenant.vo.packages.TenantPackageUpdateReqVO;
import cn.cactus.module.system.dal.dataobject.tenant.TenantPackageDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Package: cn.cactus.module.system.convert.tenant
 * Description:
 * 租户套餐 Convert
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/22 16:10
 * @Github https://github.com/lixuanfengs
 */
@Mapper
public interface TenantPackageConvert {

    TenantPackageConvert INSTANCE = Mappers.getMapper(TenantPackageConvert.class);

    TenantPackageDO convert(TenantPackageCreateReqVO bean);

    TenantPackageDO convert(TenantPackageUpdateReqVO bean);

    TenantPackageRespVO convert(TenantPackageDO bean);

    List<TenantPackageRespVO> convertList(List<TenantPackageDO> list);

    PageResult<TenantPackageRespVO> convertPage(PageResult<TenantPackageDO> page);

    List<TenantPackageSimpleRespVO> convertList02(List<TenantPackageDO> list);

}

