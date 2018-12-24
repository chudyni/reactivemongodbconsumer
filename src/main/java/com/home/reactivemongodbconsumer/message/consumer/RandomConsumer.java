package com.home.reactivemongodbconsumer.message.consumer;

import java.util.Date;

import com.home.reactivemongodbapi.model.impl.Blog;
import com.home.reactivemongodbconsumer.ReactivemongodbconsumerApplication;
import com.home.reactivemongodbconsumer.message.producer.LaterProducer;
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
//@RabbitListener(queues = ReactivemongodbconsumerApplication.RANDOM_QUEUE_NAME)
public class RandomConsumer {

  @Autowired
  private LaterProducer putForLaterProducer;

//  @RabbitHandler
  @RabbitListener(queues = ReactivemongodbconsumerApplication.RANDOM_QUEUE_NAME)
  public void receive(final Blog message) {
    //possible 1, 2
//    final int random = ThreadLocalRandom.current().nextInt(1, 3);
//    log.info("RANDOM RESULT: " + random);
//    if(random == 2) {
////      log.info("Will be dead-lettered");

//
//      log.info("Will be put for latter on own queue " + this.sdf.format(new Date()));
//      this.putForLaterProducer.putForLatter(message);
//    }
//    else {
//      log.info("Received: " + message);
//    }


    log.info("Received: " + message);
    log.info("Delaying message TIME - NOW - " + new Date());
    this.putForLaterProducer.putForLatter(message);
  }
}
