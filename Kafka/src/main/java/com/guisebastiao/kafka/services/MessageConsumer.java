package com.guisebastiao.kafka.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static com.guisebastiao.kafka.services.MessageProducer.TOPIC;

@Service
public class MessageConsumer {

    @KafkaListener(topics = TOPIC, groupId = "group-1")
    public void requestMessage(String msg) {
        System.out.println("Mensagem recebida: " + msg);
    }
}
