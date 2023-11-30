package cn.cactus.framework.sms.core.client;

import cn.cactus.framework.common.core.KeyValue;
import cn.cactus.framework.sms.core.client.dto.SmsReceiveRespDTO;
import cn.cactus.framework.sms.core.client.dto.SmsSendRespDTO;
import cn.cactus.framework.sms.core.client.dto.SmsTemplateRespDTO;

import java.util.List;

/**
 * Package: cn.cactus.framework.sms.core.client
 * Description:
 * 短信客户端，用于对接各短信平台的 SDK，实现短信发送等功能
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 16:32
 * @Github https://github.com/lixuanfengs
 */
public interface SmsClient {

    /**
     * 获得渠道编号
     *
     * @return 渠道编号
     */
    Long getId();

    /**
     * 发送消息
     *
     * @param logId 日志编号
     * @param mobile 手机号
     * @param apiTemplateId 短信 API 的模板编号
     * @param templateParams 短信模板参数。通过 List 数组，保证参数的顺序
     * @return 短信发送结果
     */
    SmsCommonResult<SmsSendRespDTO> sendSms(Long logId, String mobile, String apiTemplateId,
                                            List<KeyValue<String, Object>> templateParams);

    /**
     * 解析接收短信的接收结果
     *
     * @param text 结果
     * @return 结果内容
     * @throws Throwable 当解析 text 发生异常时，则会抛出异常
     */
    List<SmsReceiveRespDTO> parseSmsReceiveStatus(String text) throws Throwable;

    /**
     * 查询指定的短信模板
     *
     * @param apiTemplateId 短信 API 的模板编号
     * @return 短信模板
     */
    SmsCommonResult<SmsTemplateRespDTO> getSmsTemplate(String apiTemplateId);
}
