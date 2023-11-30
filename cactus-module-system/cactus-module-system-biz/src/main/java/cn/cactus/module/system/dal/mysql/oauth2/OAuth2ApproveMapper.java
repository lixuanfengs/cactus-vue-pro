package cn.cactus.module.system.dal.mysql.oauth2;

import cn.cactus.framework.mybatis.core.mapper.BaseMapperX;
import cn.cactus.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.cactus.module.system.dal.dataobject.oauth2.OAuth2ApproveDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Package: cn.cactus.module.system.dal.mysql.oauth2
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/20 11:02
 * @Github https://github.com/lixuanfengs
 */
@Mapper
public interface OAuth2ApproveMapper extends BaseMapperX<OAuth2ApproveDO> {

    default int update(OAuth2ApproveDO updateObj) {
        return update(updateObj, new LambdaQueryWrapperX<OAuth2ApproveDO>()
                .eq(OAuth2ApproveDO::getUserId, updateObj.getUserId())
                .eq(OAuth2ApproveDO::getUserType, updateObj.getUserType())
                .eq(OAuth2ApproveDO::getClientId, updateObj.getClientId())
                .eq(OAuth2ApproveDO::getScope, updateObj.getScope()));
    }

    default List<OAuth2ApproveDO> selectListByUserIdAndUserTypeAndClientId(Long userId, Integer userType, String clientId) {
        return selectList(new LambdaQueryWrapperX<OAuth2ApproveDO>()
                .eq(OAuth2ApproveDO::getUserId, userId)
                .eq(OAuth2ApproveDO::getUserType, userType)
                .eq(OAuth2ApproveDO::getClientId, clientId));
    }
}
