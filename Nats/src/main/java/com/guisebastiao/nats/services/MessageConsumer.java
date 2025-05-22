package com.guisebastiao.nats.services;

import io.nats.client.Connection;
import io.nats.client.Dispatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

import static com.guisebastiao.nats.config.NatsConfig.SUBJECT;

@Service
public class MessageConsumer {

    @Autowired
    private Connection connection;

    public MessageConsumer(Connection connection) {
        this.connection = connection;
        this.requestMessage();
    }

    private void requestMessage() {
        Dispatcher dispatcher = connection.createDispatcher((msg) -> {
            String received = new String(msg.getData(), StandardCharsets.UTF_8);
            System.out.println("Mensagem: " + received);
        });

        dispatcher.subscribe(SUBJECT);
    }
}
