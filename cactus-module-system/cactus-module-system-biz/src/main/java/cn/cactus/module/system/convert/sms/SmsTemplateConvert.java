package cn.cactus.module.system.convert.sms;

import cn.cactus.framework.common.pojo.PageResult;
import cn.cactus.module.system.controller.admin.sms.vo.template.SmsTemplateCreateReqVO;
import cn.cactus.module.system.controller.admin.sms.vo.template.SmsTemplateExcelVO;
import cn.cactus.module.system.controller.admin.sms.vo.template.SmsTemplateRespVO;
import cn.cactus.module.system.controller.admin.sms.vo.template.SmsTemplateUpdateReqVO;
import cn.cactus.module.system.dal.dataobject.sms.SmsTemplateDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Package: cn.cactus.module.system.convert.sms
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/22 16:07
 * @Github https://github.com/lixuanfengs
 */
@Mapper
public interface SmsTemplateConvert {

    SmsTemplateConvert INSTANCE = Mappers.getMapper(SmsTemplateConvert.class);

    SmsTemplateDO convert(SmsTemplateCreateReqVO bean);

    SmsTemplateDO convert(SmsTemplateUpdateReqVO bean);

    SmsTemplateRespVO convert(SmsTemplateDO bean);

    List<SmsTemplateRespVO> convertList(List<SmsTemplateDO> list);

    PageResult<SmsTemplateRespVO> convertPage(PageResult<SmsTemplateDO> page);

    List<SmsTemplateExcelVO> convertList02(List<SmsTemplateDO> list);

}
