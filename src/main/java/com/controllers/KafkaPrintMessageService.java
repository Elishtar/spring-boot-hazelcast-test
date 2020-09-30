package com.controllers;

import com.Car;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * Created by Andrey Klyuev on 30/09/2020.
 */
@Component
public class KafkaPrintMessageService {

  @KafkaListener(topics = {"out"}, groupId = "test_group" ,
          containerFactory = "kafkaListenerContainerFactory")
  public void readKafkaMessage(@Payload Car msg,
                               @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                               @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition
  ) {
    System.out.println("-------------------------------");
    System.out.println("Message: " + msg + " Topic: " + topic + " Partition: " + partition);
    System.out.println("-------------------------------");
  }

}
