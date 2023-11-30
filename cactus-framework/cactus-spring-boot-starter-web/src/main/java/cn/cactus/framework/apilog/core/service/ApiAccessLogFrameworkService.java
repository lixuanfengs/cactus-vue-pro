package cn.cactus.framework.apilog.core.service;

/**
 * Package: cn.cactus.framework.apilog.core.service
 * Description:
 * API 访问日志 Framework Service 接口
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/14 17:11
 * @Github https://github.com/lixuanfengs
 */
public interface ApiAccessLogFrameworkService {

    /**
     * 创建 API 访问日志
     *
     * @param apiAccessLog API 访问日志
     */
    void createApiAccessLog(ApiAccessLog apiAccessLog);
}
