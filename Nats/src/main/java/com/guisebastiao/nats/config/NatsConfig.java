package com.guisebastiao.nats.config;

import io.nats.client.Connection;
import io.nats.client.Nats;
import io.nats.client.Options;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NatsConfig {

    private String natsUrl = "nats://localhost:4222";

    private Connection natsConnection;

    public static final String SUBJECT = "subject";

    @Bean
    public Connection natsConnection() throws Exception {
        if (natsConnection == null || natsConnection.getStatus() != Connection.Status.CONNECTED) {
            Options options = new Options.Builder().server(natsUrl).build();
            natsConnection = Nats.connect(options);
        }
        return natsConnection;
    }

    @PreDestroy
    public void closeConnection() throws Exception {
        natsConnection.close();
    }
}