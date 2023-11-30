package cn.cactus.module.system.convert.mail;

import cn.cactus.framework.common.pojo.PageResult;
import cn.cactus.module.system.controller.admin.mail.vo.log.MailLogRespVO;
import cn.cactus.module.system.dal.dataobject.mail.MailLogDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Package: cn.cactus.module.system.convert.mail
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/22 15:57
 * @Github https://github.com/lixuanfengs
 */
@Mapper
public interface MailLogConvert {

    MailLogConvert INSTANCE = Mappers.getMapper(MailLogConvert.class);

    PageResult<MailLogRespVO> convertPage(PageResult<MailLogDO> pageResult);

    MailLogRespVO convert(MailLogDO bean);

}
