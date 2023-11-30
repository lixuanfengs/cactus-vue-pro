package cn.cactus.module.infra.service.logger;

import cn.cactus.framework.common.pojo.PageResult;
import cn.cactus.module.infra.api.logger.dto.ApiAccessLogCreateReqDTO;
import cn.cactus.module.infra.controller.admin.logger.vo.apiaccesslog.ApiAccessLogExportReqVO;
import cn.cactus.module.infra.controller.admin.logger.vo.apiaccesslog.ApiAccessLogPageReqVO;
import cn.cactus.module.infra.dal.dataobject.logger.ApiAccessLogDO;

import java.util.List;

/**
 * Package: cn.cactus.module.infra.service.logger
 * Description:
 * API 访问日志 Service 接口
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/14 17:27
 * @Github https://github.com/lixuanfengs
 */
public interface ApiAccessLogService {
    /**
     * 创建 API 访问日志
     *
     * @param createReqDTO API 访问日志
     */
    void createApiAccessLog(ApiAccessLogCreateReqDTO createReqDTO);

    /**
     * 获得 API 访问日志分页
     *
     * @param pageReqVO 分页查询
     * @return API 访问日志分页
     */
    PageResult<ApiAccessLogDO> getApiAccessLogPage(ApiAccessLogPageReqVO pageReqVO);

    /**
     * 获得 API 访问日志列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return API 访问日志分页
     */
    List<ApiAccessLogDO> getApiAccessLogList(ApiAccessLogExportReqVO exportReqVO);

    /**
     * 清理 exceedDay 天前的访问日志
     *
     * @param exceedDay 超过多少天就进行清理
     * @param deleteLimit 清理的间隔条数
     */
    Integer cleanAccessLog(Integer exceedDay, Integer deleteLimit);
}
