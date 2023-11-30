package cn.cactus.module.infra.convert.file;

import cn.cactus.framework.common.pojo.PageResult;
import cn.cactus.module.infra.controller.admin.file.vo.file.FileRespVO;
import cn.cactus.module.infra.dal.dataobject.file.FileDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Package: cn.cactus.module.infra.convert.file
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 17:50
 * @Github https://github.com/lixuanfengs
 */
@Mapper
public interface FileConvert {

    FileConvert INSTANCE = Mappers.getMapper(FileConvert.class);

    FileRespVO convert(FileDO bean);

    PageResult<FileRespVO> convertPage(PageResult<FileDO> page);

}