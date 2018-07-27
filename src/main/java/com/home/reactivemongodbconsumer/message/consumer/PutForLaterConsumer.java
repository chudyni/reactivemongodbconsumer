package com.home.reactivemongodbconsumer.message.consumer;

import com.home.reactivemongodbconsumer.ReactivemongodbconsumerApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by marcin.bracisiewicz
 */
@Component
@RabbitListener(queues = ReactivemongodbconsumerApplication.LATER_QUEUE_NAME)
@Slf4j
public class PutForLaterConsumer {

    //
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    @RabbitHandler
    public void receiveFromLaterQueue(final String message) {
        log.info("LATER CONSUMER: " + message + " " + this.sdf.format(new Date()));
    }

}
