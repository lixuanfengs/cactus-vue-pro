package cn.cactus.framework.mq.redis.core.pubsub;

import cn.cactus.framework.mq.redis.core.message.AbstractRedisMessage;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Package: cn.cactus.framework.mq.redis.core.pubsub
 * Description:
 * Redis Channel Message 抽象类
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/17 17:19
 * @Github https://github.com/lixuanfengs
 */
public abstract class AbstractRedisChannelMessage extends AbstractRedisMessage {

    /**
     * 获得 Redis Channel，默认使用类名
     *
     * @return Channel
     */
    @JsonIgnore // 避免序列化。原因是，Redis 发布 Channel 消息的时候，已经会指定。
    public String getChannel() {
        return getClass().getSimpleName();
    }
}
