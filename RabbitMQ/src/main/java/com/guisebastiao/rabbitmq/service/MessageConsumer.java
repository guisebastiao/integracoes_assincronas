package com.guisebastiao.rabbitmq.service;

import com.guisebastiao.rabbitmq.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void requestMessage(String mensagem) {
        System.out.println("Mensagem recebida: " + mensagem);
    }
}