package cn.cactus.module.infra.service.logger;

import cn.cactus.framework.common.pojo.PageResult;
import cn.cactus.module.infra.api.logger.dto.ApiErrorLogCreateReqDTO;
import cn.cactus.module.infra.controller.admin.logger.vo.apierrorlog.ApiErrorLogExportReqVO;
import cn.cactus.module.infra.controller.admin.logger.vo.apierrorlog.ApiErrorLogPageReqVO;
import cn.cactus.module.infra.dal.dataobject.logger.ApiErrorLogDO;

import java.util.List;

/**
 * Package: cn.cactus.module.infra.service.logger
 * Description:
 * API 错误日志 Service 接口
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/15 17:22
 * @Github https://github.com/lixuanfengs
 */
public interface ApiErrorLogService {

    /**
     * 创建 API 错误日志
     *
     * @param createReqDTO API 错误日志
     */
    void createApiErrorLog(ApiErrorLogCreateReqDTO createReqDTO);

    /**
     * 获得 API 错误日志分页
     *
     * @param pageReqVO 分页查询
     * @return API 错误日志分页
     */
    PageResult<ApiErrorLogDO> getApiErrorLogPage(ApiErrorLogPageReqVO pageReqVO);

    /**
     * 获得 API 错误日志列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return API 错误日志分页
     */
    List<ApiErrorLogDO> getApiErrorLogList(ApiErrorLogExportReqVO exportReqVO);

    /**
     * 更新 API 错误日志已处理
     *
     * @param id API 日志编号
     * @param processStatus 处理结果
     * @param processUserId 处理人
     */
    void updateApiErrorLogProcess(Long id, Integer processStatus, Long processUserId);

    /**
     * 清理 exceedDay 天前的错误日志
     *
     * @param exceedDay 超过多少天就进行清理
     * @param deleteLimit 清理的间隔条数
     */
    Integer cleanErrorLog(Integer exceedDay, Integer deleteLimit);

}
