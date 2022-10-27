package com.rabbitmq.service;

import com.rabbitmq.model.RabbitMessage;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    private final Logger logger = LoggerFactory.getLogger(ConsumerService.class);

    @RabbitListener(queues = "${myRabbit.queueName}")
    public void listenOnQueue(@NotNull RabbitMessage rabbitMessage) {
        logger.info("Message Consumed id:{} message:{}", rabbitMessage.getId(), rabbitMessage.getMessage());
    }
}
