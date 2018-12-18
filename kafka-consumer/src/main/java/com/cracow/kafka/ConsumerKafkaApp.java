package com.cracow.kafka;

import com.cracow.kafka.config.KafkaConfig;
import com.cracow.kafka.consumer.ConsumerCreator;
import com.cracow.kafka.dto.SensorDto;
import java.time.Instant;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;

public class ConsumerKafkaApp {

  public static void main(String[] args) {
    run();
  }

  private static void run() {
    final Consumer<Long, SensorDto> consumer = ConsumerCreator.build();

    int noMessageToFetch = 0;

    while(noMessageToFetch < KafkaConfig.MAX_NO_MESSAGE_FOUND_COUNT) {
      final ConsumerRecords<Long, SensorDto> consumerRecords = consumer.poll(1000);
      if(consumerRecords.isEmpty()) {
        noMessageToFetch++;
        continue;
      }
      consumerRecords.forEach(record -> print(record));
    }
    consumer.close();
  }

  private static void print(ConsumerRecord record) {
    SensorDto sensorDto = (SensorDto) record.value();
    if(sensorDto.getEventTime() < Instant.now().getEpochSecond()) {
      String messageLog = String.format("Key: %s, value: %s, partition: %s, offset: %s",
          record.key(), record.value(), record.partition(), record.offset());
      System.out.println(messageLog);
    }
  }
}
