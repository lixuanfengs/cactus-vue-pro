package cn.cactus.framework.websocket.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Package: cn.cactus.framework.websocket.config
 * Description:
 * WebSocket 配置项
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 17:16
 * @Github https://github.com/lixuanfengs
 */
@ConfigurationProperties("cactus.websocket")
@Data
@Validated
public class WebSocketProperties {

    /**
     * WebSocket 的连接路径
     */
    @NotEmpty(message = "WebSocket 的连接路径不能为空")
    private String path = "/ws";

    /**
     * 消息发送器的类型
     *
     * 可选值：local、redis、rocketmq、kafka、rabbitmq
     */
    @NotNull(message = "WebSocket 的消息发送者不能为空")
    private String senderType = "local";

}
