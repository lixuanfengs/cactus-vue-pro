package cn.cactus.module.system.dal.mysql.oauth2;

import cn.cactus.framework.common.pojo.PageResult;
import cn.cactus.framework.mybatis.core.mapper.BaseMapperX;
import cn.cactus.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.cactus.module.system.controller.admin.oauth2.vo.client.OAuth2ClientPageReqVO;
import cn.cactus.module.system.dal.dataobject.oauth2.OAuth2ClientDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * Package: cn.cactus.module.system.dal.mysql.oauth2
 * Description:
 * OAuth2 客户端 Mapper
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/20 11:02
 * @Github https://github.com/lixuanfengs
 */
@Mapper
public interface OAuth2ClientMapper extends BaseMapperX<OAuth2ClientDO> {

    default PageResult<OAuth2ClientDO> selectPage(OAuth2ClientPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<OAuth2ClientDO>()
                .likeIfPresent(OAuth2ClientDO::getName, reqVO.getName())
                .eqIfPresent(OAuth2ClientDO::getStatus, reqVO.getStatus())
                .orderByDesc(OAuth2ClientDO::getId));
    }

    default OAuth2ClientDO selectByClientId(String clientId) {
        return selectOne(OAuth2ClientDO::getClientId, clientId);
    }

}
