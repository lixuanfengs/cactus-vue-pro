package cn.cactus.framework.operatelog.core.service;

import cn.cactus.module.system.api.logger.OperateLogApi;
import cn.cactus.module.system.api.logger.dto.OperateLogCreateReqDTO;
import cn.hutool.core.bean.BeanUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;

/**
 * Package: cn.cactus.framework.operatelog.core.service
 * Description:
 * 操作日志 Framework Service 实现类
 *
 * 基于 {@link OperateLogApi} 实现，记录操作日志
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 14:45
 * @Github https://github.com/lixuanfengs
 */
@RequiredArgsConstructor
public class OperateLogFrameworkServiceImpl implements OperateLogFrameworkService {


    private final OperateLogApi operateLogApi;

    @Override
    @Async
    public void createOperateLog(OperateLog operateLog) {
        OperateLogCreateReqDTO reqDTO = BeanUtil.copyProperties(operateLog, OperateLogCreateReqDTO.class);
        operateLogApi.createOperateLog(reqDTO);
    }

}
