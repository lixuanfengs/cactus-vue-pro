package cn.cactus.module.infra.api.logger;

import cn.cactus.module.infra.api.logger.dto.ApiAccessLogCreateReqDTO;

import javax.validation.Valid;

/**
 * Package: cn.cactus.module.infra.api.logger
 * Description:
 * API 访问日志的 API 接口
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/14 17:33
 * @Github https://github.com/lixuanfengs
 */
public interface ApiAccessLogApi {

    /**
     * 创建 API 访问日志
     *
     * @param createDTO 创建信息
     */
    void createApiAccessLog(@Valid ApiAccessLogCreateReqDTO createDTO);
}
