package cn.cactus.module.system.mq.consumer.mail;

import cn.cactus.module.system.mq.message.mail.MailSendMessage;
import cn.cactus.module.system.service.mail.MailSendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Package: cn.cactus.module.system.mq.consumer.mail
 * Description:
 * 针对 {@link MailSendMessage} 的消费者
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/23 10:09
 * @Github https://github.com/lixuanfengs
 */
@Component
@Slf4j
public class MailSendConsumer {

    @Resource
    private MailSendService mailSendService;

    @EventListener
    @Async // Spring Event 默认在 Producer 发送的线程，通过 @Async 实现异步
    public void onMessage(MailSendMessage message) {
        log.info("[onMessage][消息内容({})]", message);
        mailSendService.doSendMail(message);
    }

}
