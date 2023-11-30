package cn.cactus.module.system.api.notify;

import cn.cactus.module.system.api.notify.dto.NotifySendSingleToUserReqDTO;

import javax.validation.Valid;

/**
 * Package: cn.cactus.module.system.api.notify
 * Description:
 * 站内信发送 API 接口
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 15:19
 * @Github https://github.com/lixuanfengs
 */
public interface NotifyMessageSendApi {

    /**
     * 发送单条站内信给 Admin 用户
     *
     * @param reqDTO 发送请求
     * @return 发送消息 ID
     */
    Long sendSingleMessageToAdmin(@Valid NotifySendSingleToUserReqDTO reqDTO);

    /**
     * 发送单条站内信给 Member 用户
     *
     * @param reqDTO 发送请求
     * @return 发送消息 ID
     */
    Long sendSingleMessageToMember(@Valid NotifySendSingleToUserReqDTO reqDTO);

}
