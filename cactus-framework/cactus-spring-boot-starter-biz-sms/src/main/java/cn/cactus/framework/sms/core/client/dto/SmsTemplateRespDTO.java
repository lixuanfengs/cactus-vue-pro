package cn.cactus.framework.sms.core.client.dto;

import cn.cactus.framework.sms.core.enums.SmsTemplateAuditStatusEnum;
import lombok.Data;

/**
 * Package: cn.cactus.framework.sms.core.client.dto
 * Description:
 * 短信模板 Response DTO
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 16:34
 * @Github https://github.com/lixuanfengs
 */
@Data
public class SmsTemplateRespDTO {

    /**
     * 模板编号
     */
    private String id;
    /**
     * 短信内容
     */
    private String content;
    /**
     * 审核状态
     *
     * 枚举 {@link SmsTemplateAuditStatusEnum}
     */
    private Integer auditStatus;
    /**
     * 审核未通过的理由
     */
    private String auditReason;
}
