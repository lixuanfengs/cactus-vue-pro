package cn.cactus.module.system.convert.social;

import cn.cactus.framework.common.pojo.PageResult;
import cn.cactus.module.system.api.social.dto.SocialUserBindReqDTO;
import cn.cactus.module.system.api.social.dto.SocialUserUnbindReqDTO;
import cn.cactus.module.system.controller.admin.socail.vo.SocialUserBindReqVO;
import cn.cactus.module.system.controller.admin.socail.vo.SocialUserUnbindReqVO;
import cn.cactus.module.system.controller.admin.socail.vo.user.SocialUserRespVO;
import cn.cactus.module.system.dal.dataobject.social.SocialUserDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Package: cn.cactus.module.system.convert
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/22 16:08
 * @Github https://github.com/lixuanfengs
 */
@Mapper
public interface SocialUserConvert {

    SocialUserConvert INSTANCE = Mappers.getMapper(SocialUserConvert.class);

    @Mapping(target = "socialType", source = "reqVO.type")
    SocialUserBindReqDTO convert(Long userId, Integer userType, SocialUserBindReqVO reqVO);

    SocialUserUnbindReqDTO convert(Long userId, Integer userType, SocialUserUnbindReqVO reqVO);

    SocialUserRespVO convert(SocialUserDO bean);

    List<SocialUserRespVO> convertList(List<SocialUserDO> list);

    PageResult<SocialUserRespVO> convertPage(PageResult<SocialUserDO> page);

}
