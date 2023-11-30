package cn.cactus.module.system.api.social;

import cn.cactus.module.system.api.social.dto.SocialUserBindReqDTO;
import cn.cactus.module.system.api.social.dto.SocialUserRespDTO;
import cn.cactus.module.system.api.social.dto.SocialUserUnbindReqDTO;
import cn.cactus.module.system.service.social.SocialUserService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;

/**
 * Package: cn.cactus.module.system.api.social
 * Description:
 * 社交用户的 API 实现类
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/23 16:57
 * @Github https://github.com/lixuanfengs
 */
@Service
@Validated
public class SocialUserApiImpl implements SocialUserApi {

    @Resource
    private SocialUserService socialUserService;

    @Override
    public String bindSocialUser(SocialUserBindReqDTO reqDTO) {
        return socialUserService.bindSocialUser(reqDTO);
    }

    @Override
    public void unbindSocialUser(SocialUserUnbindReqDTO reqDTO) {
        socialUserService.unbindSocialUser(reqDTO.getUserId(), reqDTO.getUserType(),
                reqDTO.getSocialType(), reqDTO.getOpenid());
    }

    @Override
    public SocialUserRespDTO getSocialUser(Integer userType, Integer socialType, String code, String state) {
        return socialUserService.getSocialUser(userType, socialType, code, state);
    }

}
