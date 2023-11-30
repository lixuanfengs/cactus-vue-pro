package cn.cactus.module.system.dal.mysql.oauth2;

import cn.cactus.framework.mybatis.core.mapper.BaseMapperX;
import cn.cactus.module.system.dal.dataobject.oauth2.OAuth2CodeDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * Package: cn.cactus.module.system.dal.mysql.oauth2
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/20 11:07
 * @Github https://github.com/lixuanfengs
 */
@Mapper
public interface OAuth2CodeMapper extends BaseMapperX<OAuth2CodeDO> {

    default OAuth2CodeDO selectByCode(String code) {
        return selectOne(OAuth2CodeDO::getCode, code);
    }

}
