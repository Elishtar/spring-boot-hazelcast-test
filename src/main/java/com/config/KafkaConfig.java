//package com.config;
//
//import com.Car;
//import org.apache.kafka.clients.consumer.ConsumerConfig;
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.apache.kafka.common.serialization.StringDeserializer;
//import org.apache.kafka.common.serialization.StringSerializer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
//import org.springframework.kafka.core.*;
//import org.springframework.kafka.support.serializer.JsonDeserializer;
//import org.springframework.kafka.support.serializer.JsonSerializer;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * Created by Andrey Klyuev on 30/09/2020.
// */
//@Configuration
//public class KafkaConfig {
//
//  private final String kafkaServer = "localhost:9092";
//
//  @Bean
//  public ProducerFactory<String, Car> producerFactory() {
//    Map<String, Object> config = new HashMap<>();
//    config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServer);
//    config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//    config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
//
//    return new DefaultKafkaProducerFactory<>(config);
//  }
//
//  @Bean
//  public KafkaTemplate<String, Car> kafkaTemplate() {
//    return new KafkaTemplate<>(producerFactory());
//  }
//
//  @Bean
//  public ConsumerFactory<String, Car> consumerFactory() {
//    Map<String, Object> config = new HashMap<>();
//    config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServer);
//    config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//    config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
//    config.put(ConsumerConfig.GROUP_ID_CONFIG, "test_group");
//
//    return new DefaultKafkaConsumerFactory<>(config,
//            new StringDeserializer(),
//            new JsonDeserializer<>(Car.class));
//  }
//
//  @Bean
//  public ConcurrentKafkaListenerContainerFactory<String, Car> kafkaListenerContainerFactory() {
//    final ConcurrentKafkaListenerContainerFactory<String, Car> factory = new ConcurrentKafkaListenerContainerFactory<>();
//    factory.setConsumerFactory(consumerFactory());
//    factory.setRecordFilterStrategy(record -> record.value().getId().contains("1"));
//    return factory;
//  }
//}
