package cn.cactus.module.system.service.logger;

import cn.cactus.framework.common.pojo.PageResult;
import cn.cactus.module.system.api.logger.dto.LoginLogCreateReqDTO;
import cn.cactus.module.system.controller.admin.logger.vo.loginlog.LoginLogExportReqVO;
import cn.cactus.module.system.controller.admin.logger.vo.loginlog.LoginLogPageReqVO;
import cn.cactus.module.system.convert.logger.LoginLogConvert;
import cn.cactus.module.system.dal.dataobject.logger.LoginLogDO;
import cn.cactus.module.system.dal.mysql.logger.LoginLogMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.List;

/**
 * Package: cn.cactus.module.system.service.logger
 * Description:
 * 登录日志 Service 实现
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/23 15:19
 * @Github https://github.com/lixuanfengs
 */
@Service
@Validated
public class LoginLogServiceImpl implements LoginLogService {

    @Resource
    private LoginLogMapper loginLogMapper;

    @Override
    public PageResult<LoginLogDO> getLoginLogPage(LoginLogPageReqVO reqVO) {
        return loginLogMapper.selectPage(reqVO);
    }

    @Override
    public List<LoginLogDO> getLoginLogList(LoginLogExportReqVO reqVO) {
        return loginLogMapper.selectList(reqVO);
    }

    @Override
    public void createLoginLog(LoginLogCreateReqDTO reqDTO) {
        LoginLogDO loginLog = LoginLogConvert.INSTANCE.convert(reqDTO);
        loginLogMapper.insert(loginLog);
    }

}
