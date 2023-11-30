package cn.cactus.module.infra.convert.file;

import cn.cactus.framework.common.pojo.PageResult;
import cn.cactus.module.infra.controller.admin.file.vo.config.FileConfigCreateReqVO;
import cn.cactus.module.infra.controller.admin.file.vo.config.FileConfigRespVO;
import cn.cactus.module.infra.controller.admin.file.vo.config.FileConfigUpdateReqVO;
import cn.cactus.module.infra.dal.dataobject.file.FileConfigDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Package: cn.cactus.module.infra.convert.file
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 17:51
 * @Github https://github.com/lixuanfengs
 */
@Mapper
public interface FileConfigConvert {

    FileConfigConvert INSTANCE = Mappers.getMapper(FileConfigConvert.class);

    @Mapping(target = "config", ignore = true)
    FileConfigDO convert(FileConfigCreateReqVO bean);

    @Mapping(target = "config", ignore = true)
    FileConfigDO convert(FileConfigUpdateReqVO bean);

    FileConfigRespVO convert(FileConfigDO bean);

    List<FileConfigRespVO> convertList(List<FileConfigDO> list);

    PageResult<FileConfigRespVO> convertPage(PageResult<FileConfigDO> page);

}