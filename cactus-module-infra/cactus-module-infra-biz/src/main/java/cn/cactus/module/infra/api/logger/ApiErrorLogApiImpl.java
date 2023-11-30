package cn.cactus.module.infra.api.logger;

import cn.cactus.module.infra.api.logger.dto.ApiErrorLogCreateReqDTO;
import cn.cactus.module.infra.service.logger.ApiErrorLogService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;

/**
 * Package: cn.cactus.module.infra.api.logger
 * Description:
 * API 访问日志的 API 接口
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/16 14:43
 * @Github https://github.com/lixuanfengs
 */
@Service
@Validated
public class ApiErrorLogApiImpl implements ApiErrorLogApi {

    @Resource
    private ApiErrorLogService apiErrorLogService;

    @Override
    public void createApiErrorLog(ApiErrorLogCreateReqDTO createDTO) {
        apiErrorLogService.createApiErrorLog(createDTO);
    }

}
