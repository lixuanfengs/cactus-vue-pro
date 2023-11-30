package cn.cactus.framework.websocket.core.sender.local;

import cn.cactus.framework.websocket.core.sender.AbstractWebSocketMessageSender;
import cn.cactus.framework.websocket.core.sender.WebSocketMessageSender;
import cn.cactus.framework.websocket.core.session.WebSocketSessionManager;

/**
 * Package: cn.cactus.framework.websocket.core.sender.local
 * Description:
 * 本地的 {@link WebSocketMessageSender} 实现类
 *
 * 注意：仅仅适合单机场景！！！
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/29 16:20
 * @Github https://github.com/lixuanfengs
 */
public class LocalWebSocketMessageSender extends AbstractWebSocketMessageSender {

    public LocalWebSocketMessageSender(WebSocketSessionManager sessionManager) {
        super(sessionManager);
    }

}

