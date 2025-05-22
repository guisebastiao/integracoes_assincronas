package com.guisebastiao.rabbitmq.service;

import com.guisebastiao.rabbitmq.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String msg) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME, msg);
    }
}
