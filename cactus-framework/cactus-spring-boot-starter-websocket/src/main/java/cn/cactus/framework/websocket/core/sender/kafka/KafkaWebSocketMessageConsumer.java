package cn.cactus.framework.websocket.core.sender.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.kafka.annotation.KafkaListener;

/**
 * Package: cn.cactus.framework.websocket.core.sender.kafka
 * Description:
 * {@link KafkaWebSocketMessage} 广播消息的消费者，真正把消息发送出去
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/29 16:18
 * @Github https://github.com/lixuanfengs
 */
@RequiredArgsConstructor
public class KafkaWebSocketMessageConsumer {

    private final KafkaWebSocketMessageSender rabbitMQWebSocketMessageSender;

    @RabbitHandler
    @KafkaListener(
            topics = "${cactus.websocket.sender-kafka.topic}",
            // 在 Group 上，使用 UUID 生成其后缀。这样，启动的 Consumer 的 Group 不同，以达到广播消费的目的
            groupId = "${cactus.websocket.sender-kafka.consumer-group}" + "-" + "#{T(java.util.UUID).randomUUID()}")
    public void onMessage(KafkaWebSocketMessage message) {
        rabbitMQWebSocketMessageSender.send(message.getSessionId(),
                message.getUserType(), message.getUserId(),
                message.getMessageType(), message.getMessageContent());
    }

}