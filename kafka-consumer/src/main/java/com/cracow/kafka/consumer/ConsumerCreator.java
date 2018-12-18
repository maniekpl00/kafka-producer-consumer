package com.cracow.kafka.consumer;


import com.cracow.kafka.config.KafkaConfig;
import com.cracow.kafka.deserializer.DeviceDeserializer;
import com.cracow.kafka.dto.SensorDto;
import java.util.Collections;
import java.util.Properties;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.LongDeserializer;

public final class ConsumerCreator {

  public static Consumer<Long, SensorDto> build() {
    final Properties props = new Properties();
    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConfig.KAFKA_BROKERS);
    props.put(ConsumerConfig.GROUP_ID_CONFIG, KafkaConfig.GROUP_ID_CONFIG);
    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, LongDeserializer.class.getName());
    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, DeviceDeserializer.class.getName());
    props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, KafkaConfig.MAX_POLL_RECORDS);
    props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
    props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, KafkaConfig.OFFSET_RESET_LATEST);

    final Consumer<Long, SensorDto> consumer = new KafkaConsumer<>(props);
    consumer.subscribe(Collections.singletonList(KafkaConfig.TOPIC_NAME));
    return consumer;
  }
}
