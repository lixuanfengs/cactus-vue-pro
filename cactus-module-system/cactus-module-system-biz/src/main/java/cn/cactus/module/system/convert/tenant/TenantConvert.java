package cn.cactus.module.system.convert.tenant;

import cn.cactus.framework.common.pojo.PageResult;
import cn.cactus.module.system.controller.admin.tenant.vo.tenant.*;
import cn.cactus.module.system.controller.admin.user.vo.user.UserCreateReqVO;
import cn.cactus.module.system.dal.dataobject.tenant.TenantDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Package: cn.cactus.module.system.convert.tenant
 * Description:
 * 租户 Convert
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/22 16:09
 * @Github https://github.com/lixuanfengs
 */
@Mapper
public interface TenantConvert {

    TenantConvert INSTANCE = Mappers.getMapper(TenantConvert.class);

    TenantDO convert(TenantCreateReqVO bean);

    TenantDO convert(TenantUpdateReqVO bean);

    TenantRespVO convert(TenantDO bean);

    TenantSimpleRespVO convert03(TenantDO bean);

    List<TenantRespVO> convertList(List<TenantDO> list);

    PageResult<TenantRespVO> convertPage(PageResult<TenantDO> page);

    List<TenantExcelVO> convertList02(List<TenantDO> list);

    default UserCreateReqVO convert02(TenantCreateReqVO bean) {
        UserCreateReqVO reqVO = new UserCreateReqVO();
        reqVO.setUsername(bean.getUsername());
        reqVO.setPassword(bean.getPassword());
        reqVO.setNickname(bean.getContactName()).setMobile(bean.getContactMobile());
        return reqVO;
    }

}

