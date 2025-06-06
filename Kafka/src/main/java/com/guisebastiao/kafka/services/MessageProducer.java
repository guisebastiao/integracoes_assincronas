package com.guisebastiao.kafka.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public static final String TOPIC = "topic";

    public void sendMessage(String msg) {
        kafkaTemplate.send(TOPIC, msg);
    }
}
