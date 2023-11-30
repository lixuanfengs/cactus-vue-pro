package cn.cactus.module.system.api.mail.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * Package: cn.cactus.module.system.api.mail.dto
 * Description:
 * 邮件发送 Request DTO
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 15:17
 * @Github https://github.com/lixuanfengs
 */
@Data
public class MailSendSingleToUserReqDTO {

    /**
     * 用户编号
     */
    private Long userId;
    /**
     * 邮箱
     */
    @Email
    private String mail;

    /**
     * 邮件模板编号
     */
    @NotNull(message = "邮件模板编号不能为空")
    private String templateCode;
    /**
     * 邮件模板参数
     */
    private Map<String, Object> templateParams;

}
