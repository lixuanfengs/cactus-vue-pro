package cn.cactus.module.system.convert.user;

import cn.cactus.module.system.api.user.dto.AdminUserRespDTO;
import cn.cactus.module.system.controller.admin.user.vo.profile.UserProfileRespVO;
import cn.cactus.module.system.controller.admin.user.vo.profile.UserProfileUpdatePasswordReqVO;
import cn.cactus.module.system.controller.admin.user.vo.profile.UserProfileUpdateReqVO;
import cn.cactus.module.system.controller.admin.user.vo.user.*;
import cn.cactus.module.system.dal.dataobject.dept.DeptDO;
import cn.cactus.module.system.dal.dataobject.dept.PostDO;
import cn.cactus.module.system.dal.dataobject.permission.RoleDO;
import cn.cactus.module.system.dal.dataobject.social.SocialUserDO;
import cn.cactus.module.system.dal.dataobject.user.AdminUserDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Package: cn.cactus.module.system.convert.user
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/22 16:11
 * @Github https://github.com/lixuanfengs
 */
@Mapper
public interface UserConvert {

    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

    UserPageItemRespVO convert(AdminUserDO bean);

    UserPageItemRespVO.Dept convert(DeptDO bean);

    AdminUserDO convert(UserCreateReqVO bean);

    AdminUserDO convert(UserUpdateReqVO bean);

    UserExcelVO convert02(AdminUserDO bean);

    AdminUserDO convert(UserImportExcelVO bean);

    UserProfileRespVO convert03(AdminUserDO bean);

    List<UserProfileRespVO.Role> convertList(List<RoleDO> list);

    UserProfileRespVO.Dept convert02(DeptDO bean);

    AdminUserDO convert(UserProfileUpdateReqVO bean);

    AdminUserDO convert(UserProfileUpdatePasswordReqVO bean);

    List<UserProfileRespVO.Post> convertList02(List<PostDO> list);

    List<UserProfileRespVO.SocialUser> convertList03(List<SocialUserDO> list);

    List<UserSimpleRespVO> convertList04(List<AdminUserDO> list);

    AdminUserRespDTO convert4(AdminUserDO bean);

    List<AdminUserRespDTO> convertList4(List<AdminUserDO> users);

}
