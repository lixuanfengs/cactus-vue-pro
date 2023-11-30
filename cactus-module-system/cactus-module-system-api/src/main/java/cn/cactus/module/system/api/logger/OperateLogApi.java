package cn.cactus.module.system.api.logger;

import cn.cactus.module.system.api.logger.dto.OperateLogCreateReqDTO;

import javax.validation.Valid;

/**
 * Package: cn.cactus.module.system.api.logger
 * Description:
 * 操作日志 API 接口
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 14:49
 * @Github https://github.com/lixuanfengs
 */
public interface OperateLogApi {

    /**
     * 创建操作日志
     *
     * @param createReqDTO 请求
     */
    void createOperateLog(@Valid OperateLogCreateReqDTO createReqDTO);
}
