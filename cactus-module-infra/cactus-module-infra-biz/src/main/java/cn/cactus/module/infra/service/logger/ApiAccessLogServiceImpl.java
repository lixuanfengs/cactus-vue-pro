package cn.cactus.module.infra.service.logger;

import cn.cactus.framework.common.pojo.PageResult;
import cn.cactus.module.infra.api.logger.dto.ApiAccessLogCreateReqDTO;
import cn.cactus.module.infra.controller.admin.logger.vo.apiaccesslog.ApiAccessLogExportReqVO;
import cn.cactus.module.infra.controller.admin.logger.vo.apiaccesslog.ApiAccessLogPageReqVO;
import cn.cactus.module.infra.convert.logger.ApiAccessLogConvert;
import cn.cactus.module.infra.dal.dataobject.logger.ApiAccessLogDO;
import cn.cactus.module.infra.dal.mysql.logger.ApiAccessLogMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Package: cn.cactus.module.infra.service.logger
 * Description:
 * API 访问日志 Service 实现类
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/14 17:34
 * @Github https://github.com/lixuanfengs
 */
@Slf4j
@Service
@Validated
public class ApiAccessLogServiceImpl implements ApiAccessLogService {

    @Resource
    private ApiAccessLogMapper apiAccessLogMapper;

    @Override
    public void createApiAccessLog(ApiAccessLogCreateReqDTO createDTO) {
        ApiAccessLogDO apiAccessLog = ApiAccessLogConvert.INSTANCE.convert(createDTO);
        apiAccessLogMapper.insert(apiAccessLog);
    }

    @Override
    public PageResult<ApiAccessLogDO> getApiAccessLogPage(ApiAccessLogPageReqVO pageReqVO) {
        return apiAccessLogMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ApiAccessLogDO> getApiAccessLogList(ApiAccessLogExportReqVO exportReqVO) {
        return apiAccessLogMapper.selectList(exportReqVO);
    }

    @Override
    @SuppressWarnings("DuplicatedCode")
    public Integer cleanAccessLog(Integer exceedDay, Integer deleteLimit) {
        int count = 0;
        LocalDateTime expireDate = LocalDateTime.now().minusDays(exceedDay);
        // 循环删除，直到没有满足条件的数据
        for (int i = 0; i < Short.MAX_VALUE; i++) {
            int deleteCount = apiAccessLogMapper.deleteByCreateTimeLt(expireDate, deleteLimit);
            count += deleteCount;
            // 达到删除预期条数，说明到底了
            if (deleteCount < deleteLimit) {
                break;
            }
        }
        return count;
    }
}
