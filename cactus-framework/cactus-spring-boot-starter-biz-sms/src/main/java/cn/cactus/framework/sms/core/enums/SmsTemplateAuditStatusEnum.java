package cn.cactus.framework.sms.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Package: cn.cactus.framework.sms.core.enums
 * Description:
 * 短信模板的审核状态枚举
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 16:31
 * @Github https://github.com/lixuanfengs
 */
@AllArgsConstructor
@Getter
public enum SmsTemplateAuditStatusEnum {

    CHECKING(1),
    SUCCESS(2),
    FAIL(3);

    private final Integer status;

}
