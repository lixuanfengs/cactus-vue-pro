package cn.cactus.module.system.convert.mail;

import cn.cactus.framework.common.pojo.PageResult;
import cn.cactus.module.system.controller.admin.mail.vo.template.MailTemplateCreateReqVO;
import cn.cactus.module.system.controller.admin.mail.vo.template.MailTemplateRespVO;
import cn.cactus.module.system.controller.admin.mail.vo.template.MailTemplateSimpleRespVO;
import cn.cactus.module.system.controller.admin.mail.vo.template.MailTemplateUpdateReqVO;
import cn.cactus.module.system.dal.dataobject.mail.MailTemplateDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Package: cn.cactus.module.system.convert.mail
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/22 15:58
 * @Github https://github.com/lixuanfengs
 */
@Mapper
public interface MailTemplateConvert {

    MailTemplateConvert INSTANCE = Mappers.getMapper(MailTemplateConvert.class);

    MailTemplateDO convert(MailTemplateUpdateReqVO bean);

    MailTemplateDO convert(MailTemplateCreateReqVO bean);

    MailTemplateRespVO convert(MailTemplateDO bean);

    PageResult<MailTemplateRespVO> convertPage(PageResult<MailTemplateDO> pageResult);

    List<MailTemplateSimpleRespVO> convertList02(List<MailTemplateDO> list);

}

