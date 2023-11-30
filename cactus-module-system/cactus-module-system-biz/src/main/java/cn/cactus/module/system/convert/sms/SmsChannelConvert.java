package cn.cactus.module.system.convert.sms;

import cn.cactus.framework.common.pojo.PageResult;
import cn.cactus.framework.sms.core.property.SmsChannelProperties;
import cn.cactus.module.system.controller.admin.sms.vo.channel.SmsChannelCreateReqVO;
import cn.cactus.module.system.controller.admin.sms.vo.channel.SmsChannelRespVO;
import cn.cactus.module.system.controller.admin.sms.vo.channel.SmsChannelSimpleRespVO;
import cn.cactus.module.system.controller.admin.sms.vo.channel.SmsChannelUpdateReqVO;
import cn.cactus.module.system.dal.dataobject.sms.SmsChannelDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Package: cn.cactus.module.system.convert.sms
 * Description:
 * 短信渠道 Convert
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/22 16:05
 * @Github https://github.com/lixuanfengs
 */
@Mapper
public interface SmsChannelConvert {

    SmsChannelConvert INSTANCE = Mappers.getMapper(SmsChannelConvert.class);

    SmsChannelDO convert(SmsChannelCreateReqVO bean);

    SmsChannelDO convert(SmsChannelUpdateReqVO bean);

    SmsChannelRespVO convert(SmsChannelDO bean);

    List<SmsChannelRespVO> convertList(List<SmsChannelDO> list);

    PageResult<SmsChannelRespVO> convertPage(PageResult<SmsChannelDO> page);

    List<SmsChannelSimpleRespVO> convertList03(List<SmsChannelDO> list);

    SmsChannelProperties convert02(SmsChannelDO channel);

}

