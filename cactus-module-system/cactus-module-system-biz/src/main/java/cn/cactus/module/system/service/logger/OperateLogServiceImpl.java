package cn.cactus.module.system.service.logger;

import cn.cactus.framework.common.pojo.PageResult;
import cn.cactus.framework.common.util.string.StrUtils;
import cn.cactus.module.system.api.logger.dto.OperateLogCreateReqDTO;
import cn.cactus.module.system.controller.admin.logger.vo.operatelog.OperateLogExportReqVO;
import cn.cactus.module.system.controller.admin.logger.vo.operatelog.OperateLogPageReqVO;
import cn.cactus.module.system.convert.logger.OperateLogConvert;
import cn.cactus.module.system.dal.dataobject.logger.OperateLogDO;
import cn.cactus.module.system.dal.dataobject.user.AdminUserDO;
import cn.cactus.module.system.dal.mysql.logger.OperateLogMapper;
import cn.cactus.module.system.service.user.AdminUserService;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static cn.cactus.framework.common.util.collection.CollectionUtils.convertSet;
import static cn.cactus.module.system.dal.dataobject.logger.OperateLogDO.JAVA_METHOD_ARGS_MAX_LENGTH;
import static cn.cactus.module.system.dal.dataobject.logger.OperateLogDO.RESULT_MAX_LENGTH;

/**
 * Package: cn.cactus.module.system.service.logger
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/23 15:20
 * @Github https://github.com/lixuanfengs
 */
@Service
@Validated
@Slf4j
public class OperateLogServiceImpl implements OperateLogService {

    @Resource
    private OperateLogMapper operateLogMapper;

    @Resource
    private AdminUserService userService;

    @Override
    public void createOperateLog(OperateLogCreateReqDTO createReqDTO) {
        OperateLogDO logDO = OperateLogConvert.INSTANCE.convert(createReqDTO);
        logDO.setJavaMethodArgs(StrUtils.maxLength(logDO.getJavaMethodArgs(), JAVA_METHOD_ARGS_MAX_LENGTH));
        logDO.setResultData(StrUtils.maxLength(logDO.getResultData(), RESULT_MAX_LENGTH));
        operateLogMapper.insert(logDO);
    }

    @Override
    public PageResult<OperateLogDO> getOperateLogPage(OperateLogPageReqVO reqVO) {
        // 处理基于用户昵称的查询
        Collection<Long> userIds = null;
        if (StrUtil.isNotEmpty(reqVO.getUserNickname())) {
            userIds = convertSet(userService.getUserListByNickname(reqVO.getUserNickname()), AdminUserDO::getId);
            if (CollUtil.isEmpty(userIds)) {
                return PageResult.empty();
            }
        }
        // 查询分页
        return operateLogMapper.selectPage(reqVO, userIds);
    }

    @Override
    public List<OperateLogDO> getOperateLogList(OperateLogExportReqVO reqVO) {
        // 处理基于用户昵称的查询
        Collection<Long> userIds = null;
        if (StrUtil.isNotEmpty(reqVO.getUserNickname())) {
            userIds = convertSet(userService.getUserListByNickname(reqVO.getUserNickname()), AdminUserDO::getId);
            if (CollUtil.isEmpty(userIds)) {
                return Collections.emptyList();
            }
        }
        // 查询列表
        return operateLogMapper.selectList(reqVO, userIds);
    }

}

