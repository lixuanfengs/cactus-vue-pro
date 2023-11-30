package cn.cactus.framework.apilog.core.service;

/**
 * Package: cn.cactus.framework.apilog.core.service
 * Description:
 * API 错误日志 Framework Service 接口
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/16 9:38
 * @Github https://github.com/lixuanfengs
 */
public interface ApiErrorLogFrameworkService {

    /**
     * 创建 API 错误日志
     *
     * @param apiErrorLog API 错误日志
     */
    void createApiErrorLog(ApiErrorLog apiErrorLog);
}
