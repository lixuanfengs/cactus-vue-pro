package cn.cactus.module.system.api.logger;

import cn.cactus.module.system.api.logger.dto.OperateLogCreateReqDTO;
import cn.cactus.module.system.service.logger.OperateLogService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;

/**
 * Package: cn.cactus.module.system.api.logger
 * Description:
 * 操作日志 API 实现类
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/23 16:54
 * @Github https://github.com/lixuanfengs
 */
@Service
@Validated
public class OperateLogApiImpl implements OperateLogApi {

    @Resource
    private OperateLogService operateLogService;

    @Override
    public void createOperateLog(OperateLogCreateReqDTO createReqDTO) {
        operateLogService.createOperateLog(createReqDTO);
    }

}