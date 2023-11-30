package cn.cactus.framework.mq.redis.core.stream;

import cn.cactus.framework.mq.redis.core.message.AbstractRedisMessage;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Package: cn.cactus.framework.mq.redis.core.stream
 * Description:
 * Redis Stream Message 抽象类
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/17 17:20
 * @Github https://github.com/lixuanfengs
 */
public abstract class AbstractRedisStreamMessage extends AbstractRedisMessage {

    /**
     * 获得 Redis Stream Key，默认使用类名
     *
     * @return Channel
     */
    @JsonIgnore // 避免序列化
    public String getStreamKey() {
        return getClass().getSimpleName();
    }

}
