package com.home.reactivemongodbconsumer;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReactivemongodbconsumerApplication {

  private static final String LATER_EXCHANGE = "laterExchange";

  public static final String NOTIFICATION_QUEUE_NAME = "notificationQueue";
  public static final String RANDOM_QUEUE_NAME = "randomQueue";
  public static final String LATER_QUEUE_NAME = "laterQueue";

  public static final String LATER_KEY = "random";

  public static void main(String[] args) {
    SpringApplication.run(ReactivemongodbconsumerApplication.class, args);
  }

  @Bean
  public DirectExchange laterExchange() {
    final DirectExchange delayed = new DirectExchange(LATER_EXCHANGE);
    delayed.setDelayed(true);
    return delayed;
  }

  @Bean
  public Queue laterQueue() {
    return new Queue(LATER_QUEUE_NAME);
  }

  @Bean
  public Binding randomQueueBinding(final DirectExchange laterExchange, final Queue laterQueue) {
    return BindingBuilder.bind(laterQueue)
            .to(laterExchange)
            .with(LATER_KEY);
  }
}
