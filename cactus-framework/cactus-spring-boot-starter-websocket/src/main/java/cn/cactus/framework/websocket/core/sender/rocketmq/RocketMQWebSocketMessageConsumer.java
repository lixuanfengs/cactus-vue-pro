package cn.cactus.framework.websocket.core.sender.rocketmq;

import lombok.RequiredArgsConstructor;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;

/**
 * Package: cn.cactus.framework.websocket.core.sender.rocketmq
 * Description:
 * {@link RocketMQWebSocketMessage} 广播消息的消费者，真正把消息发送出去
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/29 16:24
 * @Github https://github.com/lixuanfengs
 */
@RocketMQMessageListener( // 重点：添加 @RocketMQMessageListener 注解，声明消费的 topic
        topic = "${cactus.websocket.sender-rocketmq.topic}",
        consumerGroup = "${cactus.websocket.sender-rocketmq.consumer-group}",
        messageModel = MessageModel.BROADCASTING // 设置为广播模式，保证每个实例都能收到消息
)
@RequiredArgsConstructor
public class RocketMQWebSocketMessageConsumer implements RocketMQListener<RocketMQWebSocketMessage> {

    private final RocketMQWebSocketMessageSender rocketMQWebSocketMessageSender;

    @Override
    public void onMessage(RocketMQWebSocketMessage message) {
        rocketMQWebSocketMessageSender.send(message.getSessionId(),
                message.getUserType(), message.getUserId(),
                message.getMessageType(), message.getMessageContent());
    }

}