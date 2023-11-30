package cn.cactus.module.system.api.logger;

import cn.cactus.module.system.api.logger.dto.LoginLogCreateReqDTO;

import javax.validation.Valid;

/**
 * Package: cn.cactus.module.system.api.logger
 * Description:
 * 登录日志的 API 接口
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 14:47
 * @Github https://github.com/lixuanfengs
 */
public interface LoginLogApi {

    /**
     * 创建登录日志
     *
     * @param reqDTO 日志信息
     */
    void createLoginLog(@Valid LoginLogCreateReqDTO reqDTO);
}
