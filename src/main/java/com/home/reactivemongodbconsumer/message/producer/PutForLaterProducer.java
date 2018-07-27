package com.home.reactivemongodbconsumer.message.producer;

import com.home.reactivemongodbconsumer.ReactivemongodbconsumerApplication;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by marcin.bracisiewicz
 */
@Component
public class PutForLaterProducer {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private DirectExchange laterExchange;

    // NEEDS PLUGIN INSTALLED ??

    public void putForLatter(final String message) {
        this.template.convertAndSend(
                this.laterExchange.getName(),
                ReactivemongodbconsumerApplication.LATER_KEY,
                message,
                messagePostProcessor -> {
                    messagePostProcessor.getMessageProperties().setDelay(3000);
                    return messagePostProcessor;
                });
    }
}
