package cn.cactus.framework.websocket.core.sender.rocketmq;

import lombok.Data;

/**
 * Package: cn.cactus.framework.websocket.core.sender.rocketmq
 * Description:
 * RocketMQ 广播 WebSocket 的消息
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/29 16:24
 * @Github https://github.com/lixuanfengs
 */
@Data
public class RocketMQWebSocketMessage {

    /**
     * Session 编号
     */
    private String sessionId;
    /**
     * 用户类型
     */
    private Integer userType;
    /**
     * 用户编号
     */
    private Long userId;

    /**
     * 消息类型
     */
    private String messageType;
    /**
     * 消息内容
     */
    private String messageContent;

}

