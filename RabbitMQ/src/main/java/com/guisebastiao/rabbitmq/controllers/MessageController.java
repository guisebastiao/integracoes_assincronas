package com.guisebastiao.rabbitmq.controllers;

import com.guisebastiao.rabbitmq.service.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageProducer producer;

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody String msg) {
        producer.sendMessage(msg);
        return ResponseEntity.ok("Mensagem enviada com sucesso!");
    }
}
