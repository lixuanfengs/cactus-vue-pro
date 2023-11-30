package cn.cactus.framework.mq.redis.core.interceptor;

import cn.cactus.framework.mq.redis.core.message.AbstractRedisMessage;

/**
 * Package: cn.cactus.framework.mq.redis.core.interceptor
 * Description:
 * {@link AbstractRedisMessage} 消息拦截器
 * 通过拦截器，作为插件机制，实现拓展。
 * 例如说，多租户场景下的 MQ 消息处理
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/17 17:18
 * @Github https://github.com/lixuanfengs
 */
public interface RedisMessageInterceptor {

    default void sendMessageBefore(AbstractRedisMessage message) {
    }

    default void sendMessageAfter(AbstractRedisMessage message) {
    }

    default void consumeMessageBefore(AbstractRedisMessage message) {
    }

    default void consumeMessageAfter(AbstractRedisMessage message) {
    }

}
