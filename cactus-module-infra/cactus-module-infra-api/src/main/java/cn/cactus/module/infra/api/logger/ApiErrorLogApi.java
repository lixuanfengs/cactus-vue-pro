package cn.cactus.module.infra.api.logger;

import cn.cactus.module.infra.api.logger.dto.ApiErrorLogCreateReqDTO;

import javax.validation.Valid;

/**
 * Package: cn.cactus.module.infra.api.logger
 * Description:
 * API 错误日志的 API 接口
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/14 17:33
 * @Github https://github.com/lixuanfengs
 */
public interface ApiErrorLogApi {

    /**
     * 创建 API 错误日志
     *
     * @param createDTO 创建信息
     */
    void createApiErrorLog(@Valid ApiErrorLogCreateReqDTO createDTO);
}
