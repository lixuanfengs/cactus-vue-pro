package cn.cactus.module.system.service.logger;

import cn.cactus.framework.common.pojo.PageResult;
import cn.cactus.module.system.api.logger.dto.LoginLogCreateReqDTO;
import cn.cactus.module.system.controller.admin.logger.vo.loginlog.LoginLogExportReqVO;
import cn.cactus.module.system.controller.admin.logger.vo.loginlog.LoginLogPageReqVO;
import cn.cactus.module.system.dal.dataobject.logger.LoginLogDO;

import javax.validation.Valid;
import java.util.List;

/**
 * Package: cn.cactus.module.system.service.logger
 * Description:
 * 登录日志 Service 接口
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 10:29
 * @Github https://github.com/lixuanfengs
 */
public interface LoginLogService {

    /**
     * 获得登录日志分页
     *
     * @param reqVO 分页条件
     * @return 登录日志分页
     */
    PageResult<LoginLogDO> getLoginLogPage(LoginLogPageReqVO reqVO);

    /**
     * 获得登录日志列表
     *
     * @param reqVO 列表条件
     * @return 登录日志列表
     */
    List<LoginLogDO> getLoginLogList(LoginLogExportReqVO reqVO);

    /**
     * 创建登录日志
     *
     * @param reqDTO 日志信息
     */
    void createLoginLog(@Valid LoginLogCreateReqDTO reqDTO);
}
