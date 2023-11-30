package cn.cactus.module.system.convert.logger;

import cn.cactus.framework.common.pojo.PageResult;
import cn.cactus.framework.common.util.collection.MapUtils;
import cn.cactus.module.system.api.logger.dto.OperateLogCreateReqDTO;
import cn.cactus.module.system.controller.admin.logger.vo.operatelog.OperateLogExcelVO;
import cn.cactus.module.system.controller.admin.logger.vo.operatelog.OperateLogRespVO;
import cn.cactus.module.system.dal.dataobject.logger.OperateLogDO;
import cn.cactus.module.system.dal.dataobject.user.AdminUserDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static cn.cactus.framework.common.exception.enums.GlobalErrorCodeConstants.SUCCESS;

/**
 * Package: cn.cactus.module.system.convert.logger
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/22 15:56
 * @Github https://github.com/lixuanfengs
 */
@Mapper
public interface OperateLogConvert {

    OperateLogConvert INSTANCE = Mappers.getMapper(OperateLogConvert.class);

    OperateLogDO convert(OperateLogCreateReqDTO bean);

    PageResult<OperateLogRespVO> convertPage(PageResult<OperateLogDO> page);

    OperateLogRespVO convert(OperateLogDO bean);

    default List<OperateLogExcelVO> convertList(List<OperateLogDO> list, Map<Long, AdminUserDO> userMap) {
        return list.stream().map(operateLog -> {
            OperateLogExcelVO excelVO = convert02(operateLog);
            MapUtils.findAndThen(userMap, operateLog.getUserId(), user -> excelVO.setUserNickname(user.getNickname()));
            excelVO.setSuccessStr(SUCCESS.getCode().equals(operateLog.getResultCode()) ? "成功" : "失败");
            return excelVO;
        }).collect(Collectors.toList());
    }

    OperateLogExcelVO convert02(OperateLogDO bean);

}