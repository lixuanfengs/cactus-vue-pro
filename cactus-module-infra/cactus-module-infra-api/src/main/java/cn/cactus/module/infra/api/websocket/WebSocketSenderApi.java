package cn.cactus.module.infra.api.websocket;

import cn.cactus.framework.common.util.json.JsonUtils;

/**
 * Package: cn.cactus.module.infra.api.websocket
 * Description:
 * WebSocket 发送器的 API 接口
 *
 * 对 WebSocketMessageSender 进行封装，提供给其它模块使用
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/29 16:33
 * @Github https://github.com/lixuanfengs
 */
public interface WebSocketSenderApi {

    /**
     * 发送消息给指定用户
     *
     * @param userType 用户类型
     * @param userId 用户编号
     * @param messageType 消息类型
     * @param messageContent 消息内容，JSON 格式
     */
    void send(Integer userType, Long userId, String messageType, String messageContent);

    /**
     * 发送消息给指定用户类型
     *
     * @param userType 用户类型
     * @param messageType 消息类型
     * @param messageContent 消息内容，JSON 格式
     */
    void send(Integer userType, String messageType, String messageContent);

    /**
     * 发送消息给指定 Session
     *
     * @param sessionId Session 编号
     * @param messageType 消息类型
     * @param messageContent 消息内容，JSON 格式
     */
    void send(String sessionId, String messageType, String messageContent);

    default void sendObject(Integer userType, Long userId, String messageType, Object messageContent) {
        send(userType, userId, messageType, JsonUtils.toJsonString(messageContent));
    }

    default void sendObject(Integer userType, String messageType, Object messageContent) {
        send(userType, messageType, JsonUtils.toJsonString(messageContent));
    }

    default void sendObject(String sessionId, String messageType, Object messageContent) {
        send(sessionId, messageType, JsonUtils.toJsonString(messageContent));
    }

}
