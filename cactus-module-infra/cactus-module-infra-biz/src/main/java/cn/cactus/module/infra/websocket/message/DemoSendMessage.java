package cn.cactus.module.infra.websocket.message;

import lombok.Data;

/**
 * Package: cn.cactus.module.infra.websocket.message
 * Description:
 * 示例：client -> server 发送消息
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/29 17:14
 * @Github https://github.com/lixuanfengs
 */
@Data
public class DemoSendMessage {

    /**
     * 发送给谁
     *
     * 如果为空，说明发送给所有人
     */
    private Long toUserId;
    /**
     * 内容
     */
    private String text;

}
