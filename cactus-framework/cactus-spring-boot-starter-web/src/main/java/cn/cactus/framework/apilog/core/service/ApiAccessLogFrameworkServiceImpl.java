package cn.cactus.framework.apilog.core.service;

import cn.cactus.module.infra.api.logger.ApiAccessLogApi;
import cn.cactus.module.infra.api.logger.dto.ApiAccessLogCreateReqDTO;
import cn.hutool.core.bean.BeanUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;

/**
 * Package: cn.cactus.framework.apilog.core.service
 * Description:
 * API 访问日志 Framework Service 实现类
 *
 * 基于 {@link ApiAccessLogApi} 服务，记录访问日志
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/14 17:11
 * @Github https://github.com/lixuanfengs
 */
@RequiredArgsConstructor
public class ApiAccessLogFrameworkServiceImpl implements ApiAccessLogFrameworkService {

    private final ApiAccessLogApi apiAccessLogApi;

    @Override
    @Async
    public void createApiAccessLog(ApiAccessLog apiAccessLog) {
        ApiAccessLogCreateReqDTO reqDTO = BeanUtil.copyProperties(apiAccessLog, ApiAccessLogCreateReqDTO.class);
        apiAccessLogApi.createApiAccessLog(reqDTO);
    }
}
