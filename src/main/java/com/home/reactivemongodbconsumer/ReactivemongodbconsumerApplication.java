package com.home.reactivemongodbconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReactivemongodbconsumerApplication {

  public static final String NOTIFICATION_QUEUE_NAME = "notificationQueue";
  public static final String RANDOM_QUEUE_NAME = "randomQueue";

  public static void main(String[] args) {
    SpringApplication.run(ReactivemongodbconsumerApplication.class, args);
  }
}
