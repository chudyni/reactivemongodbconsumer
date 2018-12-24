package com.home.reactivemongodbconsumer.message.consumer;

import com.home.reactivemongodbapi.model.impl.Blog;
import com.home.reactivemongodbconsumer.ReactivemongodbconsumerApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author marcin.bracisiewicz
 */
@Slf4j
@RabbitListener(queues = ReactivemongodbconsumerApplication.NOTIFICATION_QUEUE_NAME)
@Component
public class NotificationConsumer {

  @RabbitHandler
  public void receive(final String message) {
    log.info("NOTIFICATION: " + message);
  }
}
