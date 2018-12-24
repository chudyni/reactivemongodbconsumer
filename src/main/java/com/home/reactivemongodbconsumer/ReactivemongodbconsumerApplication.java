package com.home.reactivemongodbconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReactivemongodbconsumerApplication {

  public static final String LATER_EXCHANGE = "laterExchange";             //retry exchange
  public static final String LATER_QUEUE = "laterQueue";                    //retry queue
  public static final String LATER_KEY = "laterKey";

//  public static final String RANDOM_EXCHANGE = "randomExchange";
  public static final String RANDOM_QUEUE_NAME = "randomQueue";             //working queue
//  public static final String RANDOM_key = "random";

  public static final String NOTIFICATION_QUEUE_NAME = "notificationQueue";

//  Rabbit Delayed Message Exchange
//  https://github.com/rabbitmq/rabbitmq-delayed-message-exchange
//  https://hub.docker.com/r/tetsuobe/rabbitmq-delayed-message-exchange/dockerfile/

  public static void main(String[] args) {
    SpringApplication.run(ReactivemongodbconsumerApplication.class, args);
  }

}
