package cn.cactus.framework.sms.core.client.dto;

import lombok.Data;

/**
 * Package: cn.cactus.framework.sms.core.client.dto
 * Description:
 * 短信发送 Response DTO
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 16:34
 * @Github https://github.com/lixuanfengs
 */
@Data
public class SmsSendRespDTO {

    /**
     * 短信 API 发送返回的序号
     */
    private String serialNo;

}
