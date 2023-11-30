package cn.cactus.module.system.convert.notify;

import cn.cactus.framework.common.pojo.PageResult;
import cn.cactus.framework.common.util.date.DateUtils;
import cn.cactus.module.system.controller.admin.notify.vo.template.NotifyTemplateCreateReqVO;
import cn.cactus.module.system.controller.admin.notify.vo.template.NotifyTemplateRespVO;
import cn.cactus.module.system.controller.admin.notify.vo.template.NotifyTemplateUpdateReqVO;
import cn.cactus.module.system.dal.dataobject.notify.NotifyTemplateDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Package: cn.cactus.module.system.convert.notify
 * Description:
 * 站内信模版 Convert
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/23 15:50
 * @Github https://github.com/lixuanfengs
 */
@Mapper(uses = DateUtils.class)
public interface NotifyTemplateConvert {

    NotifyTemplateConvert INSTANCE = Mappers.getMapper(NotifyTemplateConvert.class);

    NotifyTemplateDO convert(NotifyTemplateCreateReqVO bean);

    NotifyTemplateDO convert(NotifyTemplateUpdateReqVO bean);

    NotifyTemplateRespVO convert(NotifyTemplateDO bean);

    List<NotifyTemplateRespVO> convertList(List<NotifyTemplateDO> list);

    PageResult<NotifyTemplateRespVO> convertPage(PageResult<NotifyTemplateDO> page);

}
