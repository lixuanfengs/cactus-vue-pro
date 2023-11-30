package cn.cactus.module.infra.convert.db;

import cn.cactus.module.infra.controller.admin.db.vo.DataSourceConfigCreateReqVO;
import cn.cactus.module.infra.controller.admin.db.vo.DataSourceConfigRespVO;
import cn.cactus.module.infra.controller.admin.db.vo.DataSourceConfigUpdateReqVO;
import cn.cactus.module.infra.dal.dataobject.db.DataSourceConfigDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Package: cn.cactus.module.infra.convert.db
 * Description:
 * 数据源配置 Convert
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 17:50
 * @Github https://github.com/lixuanfengs
 */
@Mapper
public interface DataSourceConfigConvert {

    DataSourceConfigConvert INSTANCE = Mappers.getMapper(DataSourceConfigConvert.class);

    DataSourceConfigDO convert(DataSourceConfigCreateReqVO bean);

    DataSourceConfigDO convert(DataSourceConfigUpdateReqVO bean);

    DataSourceConfigRespVO convert(DataSourceConfigDO bean);

    List<DataSourceConfigRespVO> convertList(List<DataSourceConfigDO> list);

}
