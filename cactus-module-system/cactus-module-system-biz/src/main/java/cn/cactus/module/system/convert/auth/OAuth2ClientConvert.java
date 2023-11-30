package cn.cactus.module.system.convert.auth;

import cn.cactus.framework.common.pojo.PageResult;
import cn.cactus.module.system.controller.admin.oauth2.vo.client.OAuth2ClientCreateReqVO;
import cn.cactus.module.system.controller.admin.oauth2.vo.client.OAuth2ClientRespVO;
import cn.cactus.module.system.controller.admin.oauth2.vo.client.OAuth2ClientUpdateReqVO;
import cn.cactus.module.system.dal.dataobject.oauth2.OAuth2ClientDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Package: cn.cactus.module.system.convert.auth
 * Description:
 * OAuth2 客户端 Convert
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/20 17:47
 * @Github https://github.com/lixuanfengs
 */
@Mapper
public interface OAuth2ClientConvert {

    OAuth2ClientConvert INSTANCE = Mappers.getMapper(OAuth2ClientConvert.class);

    OAuth2ClientDO convert(OAuth2ClientCreateReqVO bean);

    OAuth2ClientDO convert(OAuth2ClientUpdateReqVO bean);

    OAuth2ClientRespVO convert(OAuth2ClientDO bean);

    List<OAuth2ClientRespVO> convertList(List<OAuth2ClientDO> list);

    PageResult<OAuth2ClientRespVO> convertPage(PageResult<OAuth2ClientDO> page);

}
