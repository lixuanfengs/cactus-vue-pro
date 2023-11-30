package cn.cactus.module.system.convert.sms;

import cn.cactus.framework.common.pojo.PageResult;
import cn.cactus.module.system.controller.admin.sms.vo.log.SmsLogExcelVO;
import cn.cactus.module.system.controller.admin.sms.vo.log.SmsLogRespVO;
import cn.cactus.module.system.dal.dataobject.sms.SmsLogDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Package: cn.cactus.module.system.convert.sms
 * Description:
 * 短信日志 Convert
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/22 16:06
 * @Github https://github.com/lixuanfengs
 */
@Mapper
public interface SmsLogConvert {

    SmsLogConvert INSTANCE = Mappers.getMapper(SmsLogConvert.class);

    SmsLogRespVO convert(SmsLogDO bean);

    List<SmsLogRespVO> convertList(List<SmsLogDO> list);

    PageResult<SmsLogRespVO> convertPage(PageResult<SmsLogDO> page);

    List<SmsLogExcelVO> convertList02(List<SmsLogDO> list);

}
