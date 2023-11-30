package cn.cactus.module.system.convert.oauth2;

import cn.cactus.module.system.controller.admin.oauth2.vo.user.OAuth2UserInfoRespVO;
import cn.cactus.module.system.controller.admin.oauth2.vo.user.OAuth2UserUpdateReqVO;
import cn.cactus.module.system.controller.admin.user.vo.profile.UserProfileUpdateReqVO;
import cn.cactus.module.system.dal.dataobject.dept.DeptDO;
import cn.cactus.module.system.dal.dataobject.dept.PostDO;
import cn.cactus.module.system.dal.dataobject.user.AdminUserDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Package: cn.cactus.module.system.convert.auth
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/20 11:16
 * @Github https://github.com/lixuanfengs
 */
@Mapper
public interface OAuth2UserConvert {

    OAuth2UserConvert INSTANCE = Mappers.getMapper(OAuth2UserConvert.class);

    OAuth2UserInfoRespVO convert(AdminUserDO bean);
    OAuth2UserInfoRespVO.Dept convert(DeptDO dept);
    List<OAuth2UserInfoRespVO.Post> convertList(List<PostDO> list);

    UserProfileUpdateReqVO convert(OAuth2UserUpdateReqVO bean);

}
