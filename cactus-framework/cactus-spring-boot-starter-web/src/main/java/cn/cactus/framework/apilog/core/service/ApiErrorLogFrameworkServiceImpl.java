package cn.cactus.framework.apilog.core.service;

import cn.cactus.module.infra.api.logger.ApiErrorLogApi;
import cn.cactus.module.infra.api.logger.dto.ApiErrorLogCreateReqDTO;
import cn.hutool.core.bean.BeanUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;

/**
 * Package: cn.cactus.framework.apilog.core.service
 * Description:
 * API 错误日志 Framework Service 实现类
 *
 * 基于 {@link ApiErrorLogApi} 服务，记录错误日志
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/16 9:38
 * @Github https://github.com/lixuanfengs
 */
@RequiredArgsConstructor
public class ApiErrorLogFrameworkServiceImpl implements ApiErrorLogFrameworkService {

    private final ApiErrorLogApi apiErrorLogApi;

    @Override
    @Async
    public void createApiErrorLog(ApiErrorLog apiErrorLog) {
        ApiErrorLogCreateReqDTO reqDTO = BeanUtil.copyProperties(apiErrorLog, ApiErrorLogCreateReqDTO.class);
        apiErrorLogApi.createApiErrorLog(reqDTO);
    }

}
