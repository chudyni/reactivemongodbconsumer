package com.home.reactivemongodbconsumer.message.consumer;

import java.util.concurrent.ThreadLocalRandom;

import com.home.reactivemongodbconsumer.ReactivemongodbconsumerApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author marcin.bracisiewicz
 */
@Component
@Slf4j
@RabbitListener(queues = ReactivemongodbconsumerApplication.RANDOM_QUEUE_NAME)
public class DeadLetteringConsumer {

  @RabbitHandler
  public void receive(final String message) {
    //possible 1, 2,
    final int random = ThreadLocalRandom.current().nextInt(1, 3);
    log.info("RANDOM RESULT: " + random);
    if(random == 2) {
      log.info("Will be dead-lettered");
    }
    else {
      log.info("RANDOM received: " + message);
    }
  }
}
