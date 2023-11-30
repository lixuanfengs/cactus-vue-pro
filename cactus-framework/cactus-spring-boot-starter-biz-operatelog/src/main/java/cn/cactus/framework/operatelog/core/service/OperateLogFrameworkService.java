package cn.cactus.framework.operatelog.core.service;

/**
 * Package: cn.cactus.framework.operatelog.core.service
 * Description:
 * 操作日志 Framework Service 接口
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 14:45
 * @Github https://github.com/lixuanfengs
 */
public interface OperateLogFrameworkService {

    /**
     * 记录操作日志
     *
     * @param operateLog 操作日志请求
     */
    void createOperateLog(OperateLog operateLog);
}
