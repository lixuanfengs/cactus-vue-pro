package cn.cactus.module.system.dal.mysql.notify;

import cn.cactus.framework.common.pojo.PageResult;
import cn.cactus.framework.mybatis.core.mapper.BaseMapperX;
import cn.cactus.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.cactus.framework.mybatis.core.query.QueryWrapperX;
import cn.cactus.module.system.controller.admin.notify.vo.message.NotifyMessageMyPageReqVO;
import cn.cactus.module.system.controller.admin.notify.vo.message.NotifyMessagePageReqVO;
import cn.cactus.module.system.dal.dataobject.notify.NotifyMessageDO;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

/**
 * Package: cn.cactus.module.system.dal.mysql.notify
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/22 16:18
 * @Github https://github.com/lixuanfengs
 */
@Mapper
public interface NotifyMessageMapper extends BaseMapperX<NotifyMessageDO> {

    default PageResult<NotifyMessageDO> selectPage(NotifyMessagePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<NotifyMessageDO>()
                .eqIfPresent(NotifyMessageDO::getUserId, reqVO.getUserId())
                .eqIfPresent(NotifyMessageDO::getUserType, reqVO.getUserType())
                .likeIfPresent(NotifyMessageDO::getTemplateCode, reqVO.getTemplateCode())
                .eqIfPresent(NotifyMessageDO::getTemplateType, reqVO.getTemplateType())
                .betweenIfPresent(NotifyMessageDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(NotifyMessageDO::getId));
    }

    default PageResult<NotifyMessageDO> selectPage(NotifyMessageMyPageReqVO reqVO, Long userId, Integer userType) {
        return selectPage(reqVO, new LambdaQueryWrapperX<NotifyMessageDO>()
                .eqIfPresent(NotifyMessageDO::getReadStatus, reqVO.getReadStatus())
                .betweenIfPresent(NotifyMessageDO::getCreateTime, reqVO.getCreateTime())
                .eq(NotifyMessageDO::getUserId, userId)
                .eq(NotifyMessageDO::getUserType, userType)
                .orderByDesc(NotifyMessageDO::getId));
    }

    default int updateListRead(Collection<Long> ids, Long userId, Integer userType) {
        return update(new NotifyMessageDO().setReadStatus(true).setReadTime(LocalDateTime.now()),
                new LambdaQueryWrapperX<NotifyMessageDO>()
                        .in(NotifyMessageDO::getId, ids)
                        .eq(NotifyMessageDO::getUserId, userId)
                        .eq(NotifyMessageDO::getUserType, userType)
                        .eq(NotifyMessageDO::getReadStatus, false));
    }

    default int updateListRead(Long userId, Integer userType) {
        return update(new NotifyMessageDO().setReadStatus(true).setReadTime(LocalDateTime.now()),
                new LambdaQueryWrapperX<NotifyMessageDO>()
                        .eq(NotifyMessageDO::getUserId, userId)
                        .eq(NotifyMessageDO::getUserType, userType)
                        .eq(NotifyMessageDO::getReadStatus, false));
    }

    default List<NotifyMessageDO> selectUnreadListByUserIdAndUserType(Long userId, Integer userType, Integer size) {
        return selectList(new QueryWrapperX<NotifyMessageDO>() // 由于要使用 limitN 语句，所以只能用 QueryWrapperX
                .eq("user_id", userId)
                .eq("user_type", userType)
                .eq("read_status", false)
                .orderByDesc("id").limitN(size));
    }

    default Long selectUnreadCountByUserIdAndUserType(Long userId, Integer userType) {
        return selectCount(new LambdaQueryWrapperX<NotifyMessageDO>()
                .eq(NotifyMessageDO::getReadStatus, false)
                .eq(NotifyMessageDO::getUserId, userId)
                .eq(NotifyMessageDO::getUserType, userType));
    }

}

