package cn.cactus.module.system.dal.mysql.sms;

import cn.cactus.framework.common.pojo.PageResult;
import cn.cactus.framework.mybatis.core.mapper.BaseMapperX;
import cn.cactus.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.cactus.module.system.controller.admin.sms.vo.log.SmsLogExportReqVO;
import cn.cactus.module.system.controller.admin.sms.vo.log.SmsLogPageReqVO;
import cn.cactus.module.system.dal.dataobject.sms.SmsLogDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Package: cn.cactus.module.system.dal.mysql.sms
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/22 16:24
 * @Github https://github.com/lixuanfengs
 */
@Mapper
public interface SmsLogMapper extends BaseMapperX<SmsLogDO> {

    default PageResult<SmsLogDO> selectPage(SmsLogPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<SmsLogDO>()
                .eqIfPresent(SmsLogDO::getChannelId, reqVO.getChannelId())
                .eqIfPresent(SmsLogDO::getTemplateId, reqVO.getTemplateId())
                .likeIfPresent(SmsLogDO::getMobile, reqVO.getMobile())
                .eqIfPresent(SmsLogDO::getSendStatus, reqVO.getSendStatus())
                .betweenIfPresent(SmsLogDO::getSendTime, reqVO.getSendTime())
                .eqIfPresent(SmsLogDO::getReceiveStatus, reqVO.getReceiveStatus())
                .betweenIfPresent(SmsLogDO::getReceiveTime, reqVO.getReceiveTime())
                .orderByDesc(SmsLogDO::getId));
    }

    default List<SmsLogDO> selectList(SmsLogExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<SmsLogDO>()
                .eqIfPresent(SmsLogDO::getChannelId, reqVO.getChannelId())
                .eqIfPresent(SmsLogDO::getTemplateId, reqVO.getTemplateId())
                .likeIfPresent(SmsLogDO::getMobile, reqVO.getMobile())
                .eqIfPresent(SmsLogDO::getSendStatus, reqVO.getSendStatus())
                .betweenIfPresent(SmsLogDO::getSendTime, reqVO.getSendTime())
                .eqIfPresent(SmsLogDO::getReceiveStatus, reqVO.getReceiveStatus())
                .betweenIfPresent(SmsLogDO::getReceiveTime, reqVO.getReceiveTime())
                .orderByDesc(SmsLogDO::getId));
    }

}

