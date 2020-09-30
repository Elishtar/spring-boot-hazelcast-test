package com.controllers;

import com.Car;
import com.Sex;
import com.hazelcast.core.IdGenerator;
import com.hazelcast.core.LifecycleEvent;
import com.hazelcast.core.LifecycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

/**
 * Created by Andrey Klyuev on 30/09/2020.
 */
@RestController
@RequestMapping("/kafka")
public class KafkaController {

//  @Autowired
//  private KafkaTemplate<String, Car> kafkaTemplate;

  @Autowired
  private KafkaTemplate<String, String> kafkaStringTemplate;

//  @PostMapping(value = "/write-data")
//  public String writeDataToHazelcast(@RequestParam String value, @RequestParam int count) {
////    for (int i = 0; i < count; i++) {
////      kafkaTemplate.send("topic4", new Car(i, "name"));
////      kafkaTemplate.send("topic5", new Car(i, "name"));
////      kafkaTemplate.send("topic6", new Car(i, "name"));
////    }
//    kafkaTemplate.send("in", new Car("1", "name", "id"));
//    return "Data is stored.";
//  }

  @PostMapping(value = "/write-data")
  public String writeDataToHazelcast() {
    kafkaStringTemplate.send("in", "111");
    kafkaStringTemplate.send("in", "222");
    kafkaStringTemplate.send("in", "333");
    return "Data is stored.";
  }

}
