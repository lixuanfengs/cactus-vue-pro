package cn.cactus.module.system.convert.dict;

import cn.cactus.framework.common.pojo.PageResult;
import cn.cactus.module.system.api.dict.dto.DictDataRespDTO;
import cn.cactus.module.system.controller.admin.dict.vo.data.*;
import cn.cactus.module.system.controller.app.dict.vo.AppDictDataRespVO;
import cn.cactus.module.system.dal.dataobject.dict.DictDataDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Package: cn.cactus.module.system.convert.dict
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/22 15:36
 * @Github https://github.com/lixuanfengs
 */
@Mapper
public interface DictDataConvert {

    DictDataConvert INSTANCE = Mappers.getMapper(DictDataConvert.class);

    List<DictDataSimpleRespVO> convertList(List<DictDataDO> list);

    DictDataRespVO convert(DictDataDO bean);

    PageResult<DictDataRespVO> convertPage(PageResult<DictDataDO> page);

    DictDataDO convert(DictDataUpdateReqVO bean);

    DictDataDO convert(DictDataCreateReqVO bean);

    List<DictDataExcelVO> convertList02(List<DictDataDO> bean);

    DictDataRespDTO convert02(DictDataDO bean);

    List<AppDictDataRespVO> convertList03(List<DictDataDO> list);

}
