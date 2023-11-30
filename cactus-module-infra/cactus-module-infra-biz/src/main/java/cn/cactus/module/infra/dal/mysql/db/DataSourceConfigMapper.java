package cn.cactus.module.infra.dal.mysql.db;

import cn.cactus.framework.mybatis.core.mapper.BaseMapperX;
import cn.cactus.module.infra.dal.dataobject.db.DataSourceConfigDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * Package: cn.cactus.module.infra.dal.mysql.db
 * Description:
 * 数据源配置 Mapper
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 15:52
 * @Github https://github.com/lixuanfengs
 */
@Mapper
public interface DataSourceConfigMapper extends BaseMapperX<DataSourceConfigDO> {
}
