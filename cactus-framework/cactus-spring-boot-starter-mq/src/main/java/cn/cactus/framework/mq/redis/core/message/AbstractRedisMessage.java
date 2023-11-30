package cn.cactus.framework.mq.redis.core.message;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * Package: cn.cactus.framework.mq.redis.core.message
 * Description:
 * Redis 消息抽象基类
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/17 17:19
 * @Github https://github.com/lixuanfengs
 */
@Data
public class AbstractRedisMessage {

    /**
     * 头
     */
    private Map<String, String> headers = new HashMap<>();

    public String getHeader(String key) {
        return headers.get(key);
    }

    public void addHeader(String key, String value) {
        headers.put(key, value);
    }
}
