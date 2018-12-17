package com.cracow.kafka.producer;

import com.cracow.kafka.config.KafkaConfig;
import com.cracow.kafka.dto.DeviceDto;
import com.cracow.kafka.serializer.DeviceSerializer;
import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.LongSerializer;

public final class ProducerKafkaCreator {

  public static Producer<Long, DeviceDto> build() {
    Properties props = new Properties();
    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConfig.KAFKA_BROKERS);
    props.put(ProducerConfig.CLIENT_ID_CONFIG, KafkaConfig.CLIENT_ID);
    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, LongSerializer.class.getName());
    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, DeviceSerializer.class.getName());
    return new KafkaProducer<>(props);
  }
}
