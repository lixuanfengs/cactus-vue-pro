package cn.cactus.module.system.api.sms;

import cn.cactus.module.system.api.sms.dto.send.SmsSendSingleToUserReqDTO;
import cn.cactus.module.system.service.sms.SmsSendService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;

/**
 * Package: cn.cactus.module.system.api
 * Description:
 * 短信发送 API 接口
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/23 16:56
 * @Github https://github.com/lixuanfengs
 */
@Service
@Validated
public class SmsSendApiImpl implements SmsSendApi {

    @Resource
    private SmsSendService smsSendService;

    @Override
    public Long sendSingleSmsToAdmin(SmsSendSingleToUserReqDTO reqDTO) {
        return smsSendService.sendSingleSmsToAdmin(reqDTO.getMobile(), reqDTO.getUserId(),
                reqDTO.getTemplateCode(), reqDTO.getTemplateParams());
    }

    @Override
    public Long sendSingleSmsToMember(SmsSendSingleToUserReqDTO reqDTO) {
        return smsSendService.sendSingleSmsToMember(reqDTO.getMobile(), reqDTO.getUserId(),
                reqDTO.getTemplateCode(), reqDTO.getTemplateParams());
    }

}
