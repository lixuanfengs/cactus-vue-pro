package cn.cactus.framework.websocket.core.sender.redis;

import cn.cactus.framework.mq.redis.core.pubsub.AbstractRedisChannelMessageListener;
import lombok.RequiredArgsConstructor;

/**
 * Package: cn.cactus.framework.websocket.core.sender.redis
 * Description:
 * {@link RedisWebSocketMessage} 广播消息的消费者，真正把消息发送出去
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/29 16:23
 * @Github https://github.com/lixuanfengs
 */
@RequiredArgsConstructor
public class RedisWebSocketMessageConsumer extends AbstractRedisChannelMessageListener<RedisWebSocketMessage> {

    private final RedisWebSocketMessageSender redisWebSocketMessageSender;

    @Override
    public void onMessage(RedisWebSocketMessage message) {
        redisWebSocketMessageSender.send(message.getSessionId(),
                message.getUserType(), message.getUserId(),
                message.getMessageType(), message.getMessageContent());
    }

}
