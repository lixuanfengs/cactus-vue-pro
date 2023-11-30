package cn.cactus.framework.tenant.core.mq.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Package: cn.cactus.framework.tenant.core.mq.rabbitmq
 * Description:
 * 多租户的 RabbitMQ 初始化器
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/17 17:06
 * @Github https://github.com/lixuanfengs
 */
public class TenantRabbitMQInitializer implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof RabbitTemplate) {
            RabbitTemplate rabbitTemplate = (RabbitTemplate) bean;
            rabbitTemplate.addBeforePublishPostProcessors(new TenantRabbitMQMessagePostProcessor());
        }
        return bean;
    }


}
