//package com.config;
//
//import com.Car;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.apache.kafka.clients.consumer.ConsumerConfig;
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.apache.kafka.common.serialization.Serde;
//import org.apache.kafka.common.serialization.Serdes;
//import org.apache.kafka.common.serialization.StringDeserializer;
//import org.apache.kafka.common.serialization.StringSerializer;
//import org.apache.kafka.streams.KafkaStreams;
//import org.apache.kafka.streams.StreamsBuilder;
//import org.apache.kafka.streams.StreamsConfig;
//import org.apache.kafka.streams.kstream.Consumed;
//import org.apache.kafka.streams.kstream.KStream;
//import org.apache.kafka.streams.kstream.Produced;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration;
//import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
//import org.springframework.kafka.config.KafkaStreamsConfiguration;
//import org.springframework.kafka.core.*;
//import org.springframework.kafka.support.serializer.JsonDeserializer;
//import org.springframework.kafka.support.serializer.JsonSerializer;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * Created by Andrey Klyuev on 30/09/2020.
// */
//@Configuration
//public class KafkaStreamsConfig {
//
//  private final String kafkaServer = "localhost:9092";
//
//  @Bean(name = KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_CONFIG_BEAN_NAME)
//  public KafkaStreamsConfiguration kStreamsConfigs() {
//    Map<String, Object> props = new HashMap<>();
//    props.put(StreamsConfig.APPLICATION_ID_CONFIG, "id");
//    props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServer);
//    props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
//    props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
//    return new KafkaStreamsConfiguration(props);
//  }
//
//  public Serde<Car> carSerde() {
//    return Serdes.serdeFrom(new JsonSerializer<>(), new JsonDeserializer<>(Car.class));
//  }
//
//  @Bean
//  public KStream<String, Car> kafkaSteam(StreamsBuilder streamsBuilder) {
//    final KStream<String, String> in = streamsBuilder.stream("in", Consumed.with(Serdes.String(), Serdes.String()));
//    final KStream<String, Car> out = in.mapValues(this::getCarFromString)
//            .filter((s, car) -> car.getId().contains("1"));
//    out.to("out", Produced.with(Serdes.String(), carSerde()));
//
//    return out;
//  }
//
//  @Bean
//  public ObjectMapper objectMapper() {
//    return new ObjectMapper();
//  }
//
//  Car getCarFromString(String carString) {
//    Car car = null;
//    try {
//      car = objectMapper().readValue(carString, Car.class);
//    } catch (JsonProcessingException e) {
//      System.out.println(e.getMessage());
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//    return car;
//  }
//
//
//
//
//
//
//}
