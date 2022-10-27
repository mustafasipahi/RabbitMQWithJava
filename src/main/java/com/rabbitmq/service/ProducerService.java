package com.rabbitmq.service;

import com.rabbitmq.model.RabbitMessage;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    private final Logger logger = LoggerFactory.getLogger(ProducerService.class);

    @Value("${myRabbit.queueName}")
    private String queueName;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendToQueue(@NotNull RabbitMessage rabbitMessage) {
        logger.info("Message Produced id:{} message:{}", rabbitMessage.getId(), rabbitMessage.getMessage());
        rabbitTemplate.convertAndSend(queueName, rabbitMessage);
    }
}
