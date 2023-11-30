package cn.cactus.module.infra.api.logger;

import cn.cactus.module.infra.api.logger.dto.ApiAccessLogCreateReqDTO;
import cn.cactus.module.infra.service.logger.ApiAccessLogService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;

/**
 * Package: cn.cactus.module.infra.api.logger
 * Description:
 * API 访问日志的 API 实现类
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/16 14:42
 * @Github https://github.com/lixuanfengs
 */
@Service
@Validated
public class ApiAccessLogApiImpl implements ApiAccessLogApi {

    @Resource
    private ApiAccessLogService apiAccessLogService;

    @Override
    public void createApiAccessLog(ApiAccessLogCreateReqDTO createDTO) {
        apiAccessLogService.createApiAccessLog(createDTO);
    }

}
