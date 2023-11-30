package cn.cactus.framework.sms.core.client;

import cn.cactus.framework.sms.core.property.SmsChannelProperties;

/**
 * Package: cn.cactus.framework.sms.core.client
 * Description:
 * 短信客户端的工厂接口
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 16:37
 * @Github https://github.com/lixuanfengs
 */
public interface SmsClientFactory {

    /**
     * 获得短信 Client
     *
     * @param channelId 渠道编号
     * @return 短信 Client
     */
    SmsClient getSmsClient(Long channelId);

    /**
     * 获得短信 Client
     *
     * @param channelCode 渠道编码
     * @return 短信 Client
     */
    SmsClient getSmsClient(String channelCode);

    /**
     * 创建短信 Client
     *
     * @param properties 配置对象
     */
    void createOrUpdateSmsClient(SmsChannelProperties properties);
}
