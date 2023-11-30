package cn.cactus.module.system.mq.message.sms;

import cn.cactus.framework.common.core.KeyValue;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Package: cn.cactus.module.system.mq.message.sms
 * Description:
 * 短信发送消息
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/23 10:16
 * @Github https://github.com/lixuanfengs
 */
@Data
public class SmsSendMessage {

    /**
     * 短信日志编号
     */
    @NotNull(message = "短信日志编号不能为空")
    private Long logId;
    /**
     * 手机号
     */
    @NotNull(message = "手机号不能为空")
    private String mobile;
    /**
     * 短信渠道编号
     */
    @NotNull(message = "短信渠道编号不能为空")
    private Long channelId;
    /**
     * 短信 API 的模板编号
     */
    @NotNull(message = "短信 API 的模板编号不能为空")
    private String apiTemplateId;
    /**
     * 短信模板参数
     */
    private List<KeyValue<String, Object>> templateParams;

}
