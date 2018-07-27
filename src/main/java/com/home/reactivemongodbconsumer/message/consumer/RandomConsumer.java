package com.home.reactivemongodbconsumer.message.consumer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import com.home.reactivemongodbconsumer.ReactivemongodbconsumerApplication;
import com.home.reactivemongodbconsumer.message.producer.PutForLaterProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author marcin.bracisiewicz
 */
@Component
@Slf4j
@RabbitListener(queues = ReactivemongodbconsumerApplication.RANDOM_QUEUE_NAME)
public class RandomConsumer {

  @Autowired
  private PutForLaterProducer putForLaterProducer;

  final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

  @RabbitHandler
  public void receive(final String message) {
    //possible 1, 2
    final int random = ThreadLocalRandom.current().nextInt(1, 3);
    log.info("RANDOM RESULT: " + random);
    if(random == 2) {
//      log.info("Will be dead-lettered");
      //https://medium.com/@kiennguyen88/rabbitmq-delay-retry-schedule-with-dead-letter-exchange-31fb25a440fc
      //https://www.cloudamqp.com/docs/delayed-messages.html

      log.info("Will be put for latter on own queue " + this.sdf.format(new Date()));
      this.putForLaterProducer.putForLatter(message);
    }
    else {
      log.info("Received: " + message);
    }
  }
}
