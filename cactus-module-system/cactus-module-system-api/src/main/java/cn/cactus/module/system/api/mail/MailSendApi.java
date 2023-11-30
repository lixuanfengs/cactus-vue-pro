package cn.cactus.module.system.api.mail;

import cn.cactus.module.system.api.mail.dto.MailSendSingleToUserReqDTO;

import javax.validation.Valid;

/**
 * Package: cn.cactus.module.system.api.mail
 * Description:
 * 邮箱发送 API 接口
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 15:17
 * @Github https://github.com/lixuanfengs
 */
public interface MailSendApi {

    /**
     * 发送单条邮箱给 Admin 用户
     *
     * 在 mail 为空时，使用 userId 加载对应 Admin 的邮箱
     *
     * @param reqDTO 发送请求
     * @return 发送日志编号
     */
    Long sendSingleMailToAdmin(@Valid MailSendSingleToUserReqDTO reqDTO);

    /**
     * 发送单条邮箱给 Member 用户
     *
     * 在 mail 为空时，使用 userId 加载对应 Member 的邮箱
     *
     * @param reqDTO 发送请求
     * @return 发送日志编号
     */
    Long sendSingleMailToMember(@Valid MailSendSingleToUserReqDTO reqDTO);

}
