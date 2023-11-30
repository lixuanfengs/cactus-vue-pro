package cn.cactus.framework.tenant.core.mq.redis;

import cn.cactus.framework.mq.redis.core.interceptor.RedisMessageInterceptor;
import cn.cactus.framework.mq.redis.core.message.AbstractRedisMessage;
import cn.cactus.framework.tenant.core.context.TenantContextHolder;
import cn.hutool.core.util.StrUtil;

import static cn.cactus.framework.web.core.util.WebFrameworkUtils.HEADER_TENANT_ID;

/**
 * Package: cn.cactus.framework.tenant.core.mq.redis
 * Description:
 * 多租户 {@link AbstractRedisMessage} 拦截器
 *
 * 1. Producer 发送消息时，将 {@link TenantContextHolder} 租户编号，添加到消息的 Header 中
 * 2. Consumer 消费消息时，将消息的 Header 的租户编号，添加到 {@link TenantContextHolder} 中
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/17 17:08
 * @Github https://github.com/lixuanfengs
 */
public class TenantRedisMessageInterceptor implements RedisMessageInterceptor {

    @Override
    public void sendMessageBefore(AbstractRedisMessage message) {
        Long tenantId = TenantContextHolder.getTenantId();
        if (tenantId != null) {
            message.addHeader(HEADER_TENANT_ID, tenantId.toString());
        }
    }

    @Override
    public void consumeMessageBefore(AbstractRedisMessage message) {
        String tenantIdStr = message.getHeader(HEADER_TENANT_ID);
        if (StrUtil.isNotEmpty(tenantIdStr)) {
            TenantContextHolder.setTenantId(Long.valueOf(tenantIdStr));
        }
    }

    @Override
    public void consumeMessageAfter(AbstractRedisMessage message) {
        // 注意，Consumer 是一个逻辑的入口，所以不考虑原本上下文就存在租户编号的情况
        TenantContextHolder.clear();
    }
}
