package cn.cactus.module.system.convert.errorcode;

import cn.cactus.framework.common.pojo.PageResult;
import cn.cactus.module.system.api.errorcode.dto.ErrorCodeAutoGenerateReqDTO;
import cn.cactus.module.system.api.errorcode.dto.ErrorCodeRespDTO;
import cn.cactus.module.system.controller.admin.errorcode.vo.ErrorCodeCreateReqVO;
import cn.cactus.module.system.controller.admin.errorcode.vo.ErrorCodeExcelVO;
import cn.cactus.module.system.controller.admin.errorcode.vo.ErrorCodeRespVO;
import cn.cactus.module.system.controller.admin.errorcode.vo.ErrorCodeUpdateReqVO;
import cn.cactus.module.system.dal.dataobject.errorcode.ErrorCodeDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Package: cn.cactus.module.system.convert.errorcode
 * Description:
 * 错误码 Convert
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/22 15:48
 * @Github https://github.com/lixuanfengs
 */
@Mapper
public interface ErrorCodeConvert {

    ErrorCodeConvert INSTANCE = Mappers.getMapper(ErrorCodeConvert.class);

    ErrorCodeDO convert(ErrorCodeCreateReqVO bean);

    ErrorCodeDO convert(ErrorCodeUpdateReqVO bean);

    ErrorCodeRespVO convert(ErrorCodeDO bean);

    List<ErrorCodeRespVO> convertList(List<ErrorCodeDO> list);

    PageResult<ErrorCodeRespVO> convertPage(PageResult<ErrorCodeDO> page);

    List<ErrorCodeExcelVO> convertList02(List<ErrorCodeDO> list);

    ErrorCodeDO convert(ErrorCodeAutoGenerateReqDTO bean);

    List<ErrorCodeRespDTO> convertList03(List<ErrorCodeDO> list);

}

