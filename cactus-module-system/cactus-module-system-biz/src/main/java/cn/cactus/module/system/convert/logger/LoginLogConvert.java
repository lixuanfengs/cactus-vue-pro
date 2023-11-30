package cn.cactus.module.system.convert.logger;

import cn.cactus.framework.common.pojo.PageResult;
import cn.cactus.module.system.api.logger.dto.LoginLogCreateReqDTO;
import cn.cactus.module.system.controller.admin.logger.vo.loginlog.LoginLogExcelVO;
import cn.cactus.module.system.controller.admin.logger.vo.loginlog.LoginLogRespVO;
import cn.cactus.module.system.dal.dataobject.logger.LoginLogDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Package: cn.cactus.module.system.convert.logger
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/22 15:55
 * @Github https://github.com/lixuanfengs
 */
@Mapper
public interface LoginLogConvert {

    LoginLogConvert INSTANCE = Mappers.getMapper(LoginLogConvert.class);

    PageResult<LoginLogRespVO> convertPage(PageResult<LoginLogDO> page);

    List<LoginLogExcelVO> convertList(List<LoginLogDO> list);

    LoginLogDO convert(LoginLogCreateReqDTO bean);

}
