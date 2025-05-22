package com.guisebastiao.nats.services;

import io.nats.client.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

import static com.guisebastiao.nats.config.NatsConfig.SUBJECT;

@Service
public class MessageProducer {

    @Autowired
    private Connection connection;

    public void sendMessage(String message) {
        connection.publish(SUBJECT, message.getBytes(StandardCharsets.UTF_8));
    }
}
