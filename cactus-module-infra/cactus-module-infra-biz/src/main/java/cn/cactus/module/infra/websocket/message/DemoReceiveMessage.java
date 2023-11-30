package cn.cactus.module.infra.websocket.message;

import lombok.Data;

/**
 * Package: cn.cactus.module.infra.websocket.message
 * Description:
 * 示例：server -> client 同步消息
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/29 17:13
 * @Github https://github.com/lixuanfengs
 */
@Data
public class DemoReceiveMessage {

    /**
     * 接收人的编号
     */
    private Long fromUserId;
    /**
     * 内容
     */
    private String text;

    /**
     * 是否单聊
     */
    private Boolean single;

}
