package cn.cactus.module.infra.convert.logger;

import cn.cactus.framework.common.pojo.PageResult;
import cn.cactus.module.infra.api.logger.dto.ApiAccessLogCreateReqDTO;
import cn.cactus.module.infra.controller.admin.logger.vo.apiaccesslog.ApiAccessLogExcelVO;
import cn.cactus.module.infra.controller.admin.logger.vo.apiaccesslog.ApiAccessLogRespVO;
import cn.cactus.module.infra.dal.dataobject.logger.ApiAccessLogDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Package: cn.cactus.module.infra.convert.logger
 * Description:
 * API 访问日志 Convert
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/15 11:14
 * @Github https://github.com/lixuanfengs
 */
@Mapper
public interface ApiAccessLogConvert {

    ApiAccessLogConvert INSTANCE = Mappers.getMapper(ApiAccessLogConvert.class);

    ApiAccessLogRespVO convert(ApiAccessLogDO bean);

    List<ApiAccessLogRespVO> convertList(List<ApiAccessLogDO> list);

    PageResult<ApiAccessLogRespVO> convertPage(PageResult<ApiAccessLogDO> page);

    List<ApiAccessLogExcelVO> convertList02(List<ApiAccessLogDO> list);

    ApiAccessLogDO convert(ApiAccessLogCreateReqDTO bean);

}