package cn.cactus.module.system.service.logger;

import cn.cactus.framework.common.pojo.PageResult;
import cn.cactus.module.system.api.logger.dto.OperateLogCreateReqDTO;
import cn.cactus.module.system.controller.admin.logger.vo.operatelog.OperateLogExportReqVO;
import cn.cactus.module.system.controller.admin.logger.vo.operatelog.OperateLogPageReqVO;
import cn.cactus.module.system.dal.dataobject.logger.OperateLogDO;

import java.util.List;

/**
 * Package: cn.cactus.module.system.service.logger
 * Description:
 * 操作日志 Service 接口
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/23 15:20
 * @Github https://github.com/lixuanfengs
 */
public interface OperateLogService {

    /**
     * 记录操作日志
     *
     * @param createReqDTO 操作日志请求
     */
    void createOperateLog(OperateLogCreateReqDTO createReqDTO);

    /**
     * 获得操作日志分页列表
     *
     * @param reqVO 分页条件
     * @return 操作日志分页列表
     */
    PageResult<OperateLogDO> getOperateLogPage(OperateLogPageReqVO reqVO);

    /**
     * 获得操作日志列表
     *
     * @param reqVO 列表条件
     * @return 日志列表
     */
    List<OperateLogDO> getOperateLogList(OperateLogExportReqVO reqVO);

}
