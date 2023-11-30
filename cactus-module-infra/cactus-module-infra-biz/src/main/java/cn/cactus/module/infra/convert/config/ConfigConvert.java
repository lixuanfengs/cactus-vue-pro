package cn.cactus.module.infra.convert.config;

import cn.cactus.framework.common.pojo.PageResult;
import cn.cactus.module.infra.controller.admin.config.vo.ConfigCreateReqVO;
import cn.cactus.module.infra.controller.admin.config.vo.ConfigExcelVO;
import cn.cactus.module.infra.controller.admin.config.vo.ConfigRespVO;
import cn.cactus.module.infra.controller.admin.config.vo.ConfigUpdateReqVO;
import cn.cactus.module.infra.dal.dataobject.config.ConfigDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Package: cn.cactus.module.infra.convert.config
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 17:50
 * @Github https://github.com/lixuanfengs
 */
@Mapper
public interface ConfigConvert {

    ConfigConvert INSTANCE = Mappers.getMapper(ConfigConvert.class);

    PageResult<ConfigRespVO> convertPage(PageResult<ConfigDO> page);

    @Mapping(source = "configKey", target = "key")
    ConfigRespVO convert(ConfigDO bean);

    @Mapping(source = "key", target = "configKey")
    ConfigDO convert(ConfigCreateReqVO bean);

    ConfigDO convert(ConfigUpdateReqVO bean);

    @Mapping(source = "configKey", target = "key")
    List<ConfigExcelVO> convertList(List<ConfigDO> list);

}

