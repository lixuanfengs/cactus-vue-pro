package cn.cactus.module.system.dal.mysql.logger;

import cn.cactus.framework.common.exception.enums.GlobalErrorCodeConstants;
import cn.cactus.framework.common.pojo.PageResult;
import cn.cactus.framework.mybatis.core.mapper.BaseMapperX;
import cn.cactus.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.cactus.module.system.controller.admin.logger.vo.operatelog.OperateLogExportReqVO;
import cn.cactus.module.system.controller.admin.logger.vo.operatelog.OperateLogPageReqVO;
import cn.cactus.module.system.dal.dataobject.logger.OperateLogDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;
import java.util.List;

/**
 * Package: cn.cactus.module.system.dal.mysql.logger
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/22 16:16
 * @Github https://github.com/lixuanfengs
 */
@Mapper
public interface OperateLogMapper extends BaseMapperX<OperateLogDO> {

    default PageResult<OperateLogDO> selectPage(OperateLogPageReqVO reqVO, Collection<Long> userIds) {
        LambdaQueryWrapperX<OperateLogDO> query = new LambdaQueryWrapperX<OperateLogDO>()
                .likeIfPresent(OperateLogDO::getModule, reqVO.getModule())
                .inIfPresent(OperateLogDO::getUserId, userIds)
                .eqIfPresent(OperateLogDO::getType, reqVO.getType())
                .betweenIfPresent(OperateLogDO::getStartTime, reqVO.getStartTime());
        if (Boolean.TRUE.equals(reqVO.getSuccess())) {
            query.eq(OperateLogDO::getResultCode, GlobalErrorCodeConstants.SUCCESS.getCode());
        } else if (Boolean.FALSE.equals(reqVO.getSuccess())) {
            query.gt(OperateLogDO::getResultCode, GlobalErrorCodeConstants.SUCCESS.getCode());
        }
        query.orderByDesc(OperateLogDO::getId); // 降序
        return selectPage(reqVO, query);
    }

    default List<OperateLogDO> selectList(OperateLogExportReqVO reqVO, Collection<Long> userIds) {
        LambdaQueryWrapperX<OperateLogDO> query = new LambdaQueryWrapperX<OperateLogDO>()
                .likeIfPresent(OperateLogDO::getModule, reqVO.getModule())
                .inIfPresent(OperateLogDO::getUserId, userIds)
                .eqIfPresent(OperateLogDO::getType, reqVO.getType())
                .betweenIfPresent(OperateLogDO::getStartTime, reqVO.getStartTime());
        if (Boolean.TRUE.equals(reqVO.getSuccess())) {
            query.eq(OperateLogDO::getResultCode, GlobalErrorCodeConstants.SUCCESS.getCode());
        } else if (Boolean.FALSE.equals(reqVO.getSuccess())) {
            query.gt(OperateLogDO::getResultCode, GlobalErrorCodeConstants.SUCCESS.getCode());
        }
        query.orderByDesc(OperateLogDO::getId); // 降序
        return selectList(query);
    }

}
