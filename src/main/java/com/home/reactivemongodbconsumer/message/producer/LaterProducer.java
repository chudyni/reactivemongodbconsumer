package com.home.reactivemongodbconsumer.message.producer;


import com.home.reactivemongodbapi.model.impl.Blog;
import com.home.reactivemongodbconsumer.ReactivemongodbconsumerApplication;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.utils.SerializationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by marcin.bracisiewicz
 */
@Component
public class LaterProducer {

    @Autowired
    private RabbitTemplate template;

    public void putForLatter(final Blog message) {
        this.template.convertAndSend(
                ReactivemongodbconsumerApplication.LATER_EXCHANGE,
                ReactivemongodbconsumerApplication.LATER_KEY,
                this.createDelayedMessage(message)
        );
    }

    private Message createDelayedMessage(final Blog message) {
        final MessageProperties properties = new MessageProperties();
        properties.setContentType(MessageProperties.CONTENT_TYPE_SERIALIZED_OBJECT);
        properties.setDelay(5000);
        return MessageBuilder
                .withBody(SerializationUtils.serialize(message))
                .andProperties(properties)
                .build();
    }
}
