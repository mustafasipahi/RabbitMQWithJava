package com.rabbitmq.controller;

import com.rabbitmq.model.RabbitMessage;
import com.rabbitmq.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/message")
public class RabbitMQController {

    @Autowired
    private ProducerService producerService;

    @PostMapping("/send")
    public void sendMessage(@RequestBody RabbitMessage request) {

        final RabbitMessage rabbitMessage = new RabbitMessage();
        rabbitMessage.setId(UUID.randomUUID().toString());
        rabbitMessage.setName(request.getName());
        rabbitMessage.setMessage(request.getMessage());

        producerService.sendToQueue(rabbitMessage);
    }
}
