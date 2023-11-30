package cn.cactus.module.system.api.social;

import cn.binarywang.wx.miniapp.bean.WxMaPhoneNumberInfo;
import cn.cactus.module.system.api.social.dto.SocialWxJsapiSignatureRespDTO;
import cn.cactus.module.system.api.social.dto.SocialWxPhoneNumberInfoRespDTO;
import cn.cactus.module.system.convert.social.SocialClientConvert;
import cn.cactus.module.system.service.social.SocialClientService;
import me.chanjar.weixin.common.bean.WxJsapiSignature;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;

/**
 * Package: cn.cactus.module.system.api.social
 * Description:
 * 社交应用的 API 实现类
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/23 16:57
 * @Github https://github.com/lixuanfengs
 */
@Service
@Validated
public class SocialClientApiImpl implements SocialClientApi {

    @Resource
    private SocialClientService socialClientService;

    @Override
    public String getAuthorizeUrl(Integer socialType, Integer userType, String redirectUri) {
        return socialClientService.getAuthorizeUrl(socialType, userType, redirectUri);
    }

    @Override
    public SocialWxJsapiSignatureRespDTO createWxMpJsapiSignature(Integer userType, String url) {
        WxJsapiSignature signature = socialClientService.createWxMpJsapiSignature(userType, url);
        return SocialClientConvert.INSTANCE.convert(signature);
    }

    @Override
    public SocialWxPhoneNumberInfoRespDTO getWxMaPhoneNumberInfo(Integer userType, String phoneCode) {
        WxMaPhoneNumberInfo info = socialClientService.getWxMaPhoneNumberInfo(userType, phoneCode);
        return SocialClientConvert.INSTANCE.convert(info);
    }

}
