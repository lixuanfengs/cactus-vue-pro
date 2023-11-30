package cn.cactus.module.system.api.logger;

import cn.cactus.module.system.api.logger.dto.LoginLogCreateReqDTO;
import cn.cactus.module.system.service.logger.LoginLogService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;

/**
 * Package: cn.cactus.module.system.api.logger
 * Description:
 * 登录日志的 API 实现类
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/23 16:53
 * @Github https://github.com/lixuanfengs
 */
@Service
@Validated
public class LoginLogApiImpl implements LoginLogApi {

    @Resource
    private LoginLogService loginLogService;

    @Override
    public void createLoginLog(LoginLogCreateReqDTO reqDTO) {
        loginLogService.createLoginLog(reqDTO);
    }

}