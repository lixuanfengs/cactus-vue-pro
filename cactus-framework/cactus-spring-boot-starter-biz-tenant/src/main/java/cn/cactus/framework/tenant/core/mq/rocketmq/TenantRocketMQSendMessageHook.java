package cn.cactus.framework.tenant.core.mq.rocketmq;

import cn.cactus.framework.tenant.core.context.TenantContextHolder;
import org.apache.rocketmq.client.hook.SendMessageContext;
import org.apache.rocketmq.client.hook.SendMessageHook;

import static cn.cactus.framework.web.core.util.WebFrameworkUtils.HEADER_TENANT_ID;

/**
 * Package: cn.cactus.framework.tenant.core.mq.rocketmq
 * Description:
 * RocketMQ 消息队列的多租户 {@link SendMessageHook} 实现类
 *
 * Producer 发送消息时，将 {@link TenantContextHolder} 租户编号，添加到消息的 Header 中
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/17 17:10
 * @Github https://github.com/lixuanfengs
 */
public class TenantRocketMQSendMessageHook implements SendMessageHook {

    @Override
    public String hookName() {
        return getClass().getSimpleName();
    }

    @Override
    public void sendMessageBefore(SendMessageContext sendMessageContext) {
        Long tenantId = TenantContextHolder.getTenantId();
        if (tenantId == null) {
            return;
        }
        sendMessageContext.getMessage().putUserProperty(HEADER_TENANT_ID, tenantId.toString());
    }

    @Override
    public void sendMessageAfter(SendMessageContext sendMessageContext) {
    }

}
