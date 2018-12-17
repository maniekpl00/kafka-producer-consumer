package com.cracow.kafka;

import com.cracow.kafka.config.KafkaConfig;
import com.cracow.kafka.dto.SensorDto;
import com.cracow.kafka.producer.ProducerKafkaCreator;
import com.cracow.kafka.serializer.DeviceSerializer;
import java.util.concurrent.ExecutionException;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

public class ProducerKafkaApp {

  public static void main(String[] args) {
    run();
  }

  private static void run() {
    final Producer<Long, SensorDto> producer = ProducerKafkaCreator.build();
    final DeviceSerializer deviceSerializer = new DeviceSerializer();

    for(int i = 0; i < KafkaConfig.MESSAGE_COUNT; i++) {
      SensorDto sensorDto = new SensorDto(String.valueOf(i), "Name" + i);

      final ProducerRecord<Long, SensorDto> record =
          new ProducerRecord<>(KafkaConfig.TOPIC_NAME, sensorDto);
      try {
        RecordMetadata metadata = producer.send(record).get();
        System.out.println("Record sent with key " + i + " to partition " + metadata.partition()
            + " with offset " + metadata.offset());
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (ExecutionException e) {
        e.printStackTrace();
      }
    }
  }
}
