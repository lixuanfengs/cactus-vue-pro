package cn.cactus.module.system.convert.social;

import cn.binarywang.wx.miniapp.bean.WxMaPhoneNumberInfo;
import cn.cactus.framework.common.pojo.PageResult;
import cn.cactus.module.system.api.social.dto.SocialWxJsapiSignatureRespDTO;
import cn.cactus.module.system.api.social.dto.SocialWxPhoneNumberInfoRespDTO;
import cn.cactus.module.system.controller.admin.socail.vo.client.SocialClientCreateReqVO;
import cn.cactus.module.system.controller.admin.socail.vo.client.SocialClientRespVO;
import cn.cactus.module.system.controller.admin.socail.vo.client.SocialClientUpdateReqVO;
import cn.cactus.module.system.dal.dataobject.social.SocialClientDO;
import me.chanjar.weixin.common.bean.WxJsapiSignature;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Package: cn.cactus.module.system.convert.social
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/22 16:07
 * @Github https://github.com/lixuanfengs
 */
@Mapper
public interface SocialClientConvert {

    SocialClientConvert INSTANCE = Mappers.getMapper(SocialClientConvert.class);

    SocialWxJsapiSignatureRespDTO convert(WxJsapiSignature bean);

    SocialWxPhoneNumberInfoRespDTO convert(WxMaPhoneNumberInfo bean);

    SocialClientDO convert(SocialClientCreateReqVO bean);

    SocialClientDO convert(SocialClientUpdateReqVO bean);

    SocialClientRespVO convert(SocialClientDO bean);

    List<SocialClientRespVO> convertList(List<SocialClientDO> list);

    PageResult<SocialClientRespVO> convertPage(PageResult<SocialClientDO> page);

}