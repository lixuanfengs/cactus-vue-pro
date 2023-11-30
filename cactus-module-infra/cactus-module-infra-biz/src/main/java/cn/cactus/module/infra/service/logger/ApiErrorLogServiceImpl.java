package cn.cactus.module.infra.service.logger;


import cn.cactus.framework.common.pojo.PageResult;
import cn.cactus.module.infra.api.logger.dto.ApiErrorLogCreateReqDTO;
import cn.cactus.module.infra.controller.admin.logger.vo.apierrorlog.ApiErrorLogExportReqVO;
import cn.cactus.module.infra.controller.admin.logger.vo.apierrorlog.ApiErrorLogPageReqVO;
import cn.cactus.module.infra.convert.logger.ApiErrorLogConvert;
import cn.cactus.module.infra.dal.dataobject.logger.ApiErrorLogDO;
import cn.cactus.module.infra.dal.mysql.logger.ApiErrorLogMapper;
import cn.cactus.module.infra.enums.logger.ApiErrorLogProcessStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

import static cn.cactus.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.cactus.module.infra.enums.ErrorCodeConstants.API_ERROR_LOG_NOT_FOUND;
import static cn.cactus.module.infra.enums.ErrorCodeConstants.API_ERROR_LOG_PROCESSED;

/**
 * Package: cn.cactus.module.infra.service.logger
 * Description:
 * API 错误日志 Service 实现类
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/15 17:39
 * @Github https://github.com/lixuanfengs
 */
@Slf4j
@Service
@Validated
public class ApiErrorLogServiceImpl implements ApiErrorLogService {

    @Resource
    private ApiErrorLogMapper apiErrorLogMapper;

    @Override
    public void createApiErrorLog(ApiErrorLogCreateReqDTO createDTO) {
        ApiErrorLogDO apiErrorLog = ApiErrorLogConvert.INSTANCE.convert(createDTO)
                .setProcessStatus(ApiErrorLogProcessStatusEnum.INIT.getStatus());
        apiErrorLogMapper.insert(apiErrorLog);
    }

    @Override
    public PageResult<ApiErrorLogDO> getApiErrorLogPage(ApiErrorLogPageReqVO pageReqVO) {
        return apiErrorLogMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ApiErrorLogDO> getApiErrorLogList(ApiErrorLogExportReqVO exportReqVO) {
        return apiErrorLogMapper.selectList(exportReqVO);
    }

    @Override
    public void updateApiErrorLogProcess(Long id, Integer processStatus, Long processUserId) {
        ApiErrorLogDO errorLog = apiErrorLogMapper.selectById(id);
        if (errorLog == null) {
            throw exception(API_ERROR_LOG_NOT_FOUND);
        }
        if (!ApiErrorLogProcessStatusEnum.INIT.getStatus().equals(errorLog.getProcessStatus())) {
            throw exception(API_ERROR_LOG_PROCESSED);
        }
        // 标记处理
        apiErrorLogMapper.updateById(ApiErrorLogDO.builder().id(id).processStatus(processStatus)
                .processUserId(processUserId).processTime(LocalDateTime.now()).build());
    }

    @Override
    @SuppressWarnings("DuplicatedCode")
    public Integer cleanErrorLog(Integer exceedDay, Integer deleteLimit) {
        int count = 0;
        LocalDateTime expireDate = LocalDateTime.now().minusDays(exceedDay);
        // 循环删除，直到没有满足条件的数据
        for (int i = 0; i < Short.MAX_VALUE; i++) {
            int deleteCount = apiErrorLogMapper.deleteByCreateTimeLt(expireDate, deleteLimit);
            count += deleteCount;
            // 达到删除预期条数，说明到底了
            if (deleteCount < deleteLimit) {
                break;
            }
        }
        return count;
    }

}
