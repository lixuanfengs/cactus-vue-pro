package cn.cactus.module.system.api.notify;

import cn.cactus.module.system.api.notify.dto.NotifySendSingleToUserReqDTO;
import cn.cactus.module.system.service.notify.NotifySendService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Package: cn.cactus.module.system.api.notify
 * Description:
 * 站内信发送 API 实现类
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/23 16:54
 * @Github https://github.com/lixuanfengs
 */
@Service
public class NotifyMessageSendApiImpl implements NotifyMessageSendApi {

    @Resource
    private NotifySendService notifySendService;

    @Override
    public Long sendSingleMessageToAdmin(NotifySendSingleToUserReqDTO reqDTO) {
        return notifySendService.sendSingleNotifyToAdmin(reqDTO.getUserId(),
                reqDTO.getTemplateCode(), reqDTO.getTemplateParams());
    }

    @Override
    public Long sendSingleMessageToMember(NotifySendSingleToUserReqDTO reqDTO) {
        return notifySendService.sendSingleNotifyToMember(reqDTO.getUserId(),
                reqDTO.getTemplateCode(), reqDTO.getTemplateParams());
    }

}

