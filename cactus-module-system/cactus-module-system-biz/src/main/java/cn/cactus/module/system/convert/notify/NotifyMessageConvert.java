package cn.cactus.module.system.convert.notify;

import cn.cactus.framework.common.pojo.PageResult;
import cn.cactus.module.system.controller.admin.notify.vo.message.NotifyMessageRespVO;
import cn.cactus.module.system.dal.dataobject.notify.NotifyMessageDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Package: cn.cactus.module.system.convert.notify
 * Description:
 * 站内信 Convert
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/22 15:59
 * @Github https://github.com/lixuanfengs
 */
@Mapper
public interface NotifyMessageConvert {

    NotifyMessageConvert INSTANCE = Mappers.getMapper(NotifyMessageConvert.class);

    NotifyMessageRespVO convert(NotifyMessageDO bean);

    List<NotifyMessageRespVO> convertList(List<NotifyMessageDO> list);

    PageResult<NotifyMessageRespVO> convertPage(PageResult<NotifyMessageDO> page);

}
