package cn.cactus.module.system.service.social;

import cn.cactus.framework.common.exception.ServiceException;
import cn.cactus.framework.common.pojo.PageResult;
import cn.cactus.module.system.api.social.dto.SocialUserBindReqDTO;
import cn.cactus.module.system.api.social.dto.SocialUserRespDTO;
import cn.cactus.module.system.controller.admin.socail.vo.user.SocialUserPageReqVO;
import cn.cactus.module.system.dal.dataobject.social.SocialUserDO;
import cn.cactus.module.system.enums.social.SocialTypeEnum;

import javax.validation.Valid;
import java.util.List;

/**
 * Package: cn.cactus.module.system.service.social
 * Description:
 * 社交用户 Service 接口，例如说社交平台的授权登录
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/23 16:31
 * @Github https://github.com/lixuanfengs
 */
public interface SocialUserService {

    /**
     * 获得指定用户的社交用户列表
     *
     * @param userId   用户编号
     * @param userType 用户类型
     * @return 社交用户列表
     */
    List<SocialUserDO> getSocialUserList(Long userId, Integer userType);

    /**
     * 绑定社交用户
     *
     * @param reqDTO 绑定信息
     * @return 社交用户 openid
     */
    String bindSocialUser(@Valid SocialUserBindReqDTO reqDTO);

    /**
     * 取消绑定社交用户
     *
     * @param userId 用户编号
     * @param userType 全局用户类型
     * @param socialType 社交平台的类型 {@link SocialTypeEnum}
     * @param openid 社交平台的 openid
     */
    void unbindSocialUser(Long userId, Integer userType, Integer socialType, String openid);

    /**
     * 获得社交用户
     *
     * 在认证信息不正确的情况下，也会抛出 {@link ServiceException} 业务异常
     *
     * @param userType 用户类型
     * @param socialType 社交平台的类型
     * @param code 授权码
     * @param state state
     * @return 社交用户
     */
    SocialUserRespDTO getSocialUser(Integer userType, Integer socialType, String code, String state);

    // ==================== 社交用户 CRUD ====================

    /**
     * 获得社交用户
     *
     * @param id 编号
     * @return 社交用户
     */
    SocialUserDO getSocialUser(Long id);

    /**
     * 获得社交用户分页
     *
     * @param pageReqVO 分页查询
     * @return 社交用户分页
     */
    PageResult<SocialUserDO> getSocialUserPage(SocialUserPageReqVO pageReqVO);

}