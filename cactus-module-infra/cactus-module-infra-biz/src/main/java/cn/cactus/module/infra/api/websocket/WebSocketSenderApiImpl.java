package cn.cactus.module.infra.api.websocket;

import cn.cactus.framework.websocket.core.sender.WebSocketMessageSender;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Package: cn.cactus.module.infra.api.websocket
 * Description:
 * WebSocket 发送器的 API 实现类
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/29 16:34
 * @Github https://github.com/lixuanfengs
 */
@Component
public class WebSocketSenderApiImpl implements WebSocketSenderApi {

    @Resource
    private WebSocketMessageSender webSocketMessageSender;

    @Override
    public void send(Integer userType, Long userId, String messageType, String messageContent) {
        webSocketMessageSender.send(userType, userId, messageType, messageContent);
    }

    @Override
    public void send(Integer userType, String messageType, String messageContent) {
        webSocketMessageSender.send(userType, messageType, messageContent);
    }

    @Override
    public void send(String sessionId, String messageType, String messageContent) {
        webSocketMessageSender.send(sessionId, messageType, messageContent);
    }

}
