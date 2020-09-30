package com.config;

import com.Car;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration;
import org.springframework.kafka.config.KafkaStreamsConfiguration;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andrey Klyuev on 30/09/2020.
 */
@Configuration
public class KafkaStreamsStringConfig {

  private final String kafkaServer = "localhost:9092";

  @Bean(name = KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_CONFIG_BEAN_NAME)
  public KafkaStreamsConfiguration kStreamsConfigs() {
    Map<String, Object> props = new HashMap<>();
    props.put(StreamsConfig.APPLICATION_ID_CONFIG, "id");
    props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServer);
    props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
    props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
    return new KafkaStreamsConfiguration(props);
  }

  @Bean
  public KStream<String, String> kafkaSteam(StreamsBuilder streamsBuilder) {
    final KStream<String, String> in = streamsBuilder.stream("in", Consumed.with(Serdes.String(), Serdes.String()));
    final KStream<String, String> out = in.filter((s, str) -> str.contains("2"));
    out.to("out", Produced.with(Serdes.String(), Serdes.String()));

    return out;
  }

}
