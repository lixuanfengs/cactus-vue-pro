package cn.cactus.module.infra.convert.logger;

import cn.cactus.framework.common.pojo.PageResult;
import cn.cactus.module.infra.api.logger.dto.ApiErrorLogCreateReqDTO;
import cn.cactus.module.infra.controller.admin.logger.vo.apierrorlog.ApiErrorLogExcelVO;
import cn.cactus.module.infra.controller.admin.logger.vo.apierrorlog.ApiErrorLogRespVO;
import cn.cactus.module.infra.dal.dataobject.logger.ApiErrorLogDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Package: cn.cactus.module.infra.convert.logger
 * Description:
 * API 错误日志 Convert
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/15 11:15
 * @Github https://github.com/lixuanfengs
 */
@Mapper
public interface ApiErrorLogConvert {

    ApiErrorLogConvert INSTANCE = Mappers.getMapper(ApiErrorLogConvert.class);

    ApiErrorLogRespVO convert(ApiErrorLogDO bean);

    PageResult<ApiErrorLogRespVO> convertPage(PageResult<ApiErrorLogDO> page);

    List<ApiErrorLogExcelVO> convertList02(List<ApiErrorLogDO> list);

    ApiErrorLogDO convert(ApiErrorLogCreateReqDTO bean);

}
