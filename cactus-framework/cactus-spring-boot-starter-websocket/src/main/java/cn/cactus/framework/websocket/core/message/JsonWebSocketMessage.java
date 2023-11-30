package cn.cactus.framework.websocket.core.message;

import cn.cactus.framework.websocket.core.listener.WebSocketMessageListener;
import lombok.Data;

import java.io.Serializable;

/**
 * Package: cn.cactus.framework.websocket.core.message
 * Description:
 * JSON 格式的 WebSocket 消息帧
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/29 16:05
 * @Github https://github.com/lixuanfengs
 */
@Data
public class JsonWebSocketMessage implements Serializable {

    /**
     * 消息类型
     *
     * 目的：用于分发到对应的 {@link WebSocketMessageListener} 实现类
     */
    private String type;
    /**
     * 消息内容
     *
     * 要求 JSON 对象
     */
    private String content;

}
