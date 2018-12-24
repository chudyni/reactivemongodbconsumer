package com.home.reactivemongodbconsumer.message.consumer;

import com.home.reactivemongodbapi.model.impl.Blog;
import com.home.reactivemongodbconsumer.ReactivemongodbconsumerApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by marcin.bracisiewicz
 */
@Component
@Slf4j
public class LaterConsumer {

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(value = ReactivemongodbconsumerApplication.LATER_QUEUE),
                    key = ReactivemongodbconsumerApplication.LATER_KEY,
                    exchange = @Exchange(
                            value = ReactivemongodbconsumerApplication.LATER_EXCHANGE,
                            delayed = "true"
                    )
            )
    )
    public void receiveFromLaterQueue(final Blog message) {
        log.info("Received DELAYED : " + message + " " + new Date());
    }

}
